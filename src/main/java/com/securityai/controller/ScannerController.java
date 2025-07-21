package com.securityai.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ScannerController {

    // Define a Port class to hold port scan data
    public static class Port {
        private String number;
        private String state;
        private String service;
        private String riskLevel;
        
        public Port(String number, String state, String service, String riskLevel) {
            this.number = number;
            this.state = state;
            this.service = service;
            this.riskLevel = riskLevel;
        }
        
        // Getters and setters
        public String getNumber() { return number; }
        public void setNumber(String number) { this.number = number; }
        
        public String getState() { return state; }
        public void setState(String state) { this.state = state; }
        
        public String getService() { return service; }
        public void setService(String service) { this.service = service; }
        
        public String getRiskLevel() { return riskLevel; }
        public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    }
    
    // Risk level mapping for common services
    private static final Map<String, String> SERVICE_RISK_MAP = new HashMap<>();
    static {
        // High risk services
        SERVICE_RISK_MAP.put("microsoft-ds", "high");
        SERVICE_RISK_MAP.put("netbios-ssn", "high");
        SERVICE_RISK_MAP.put("telnet", "high");
        SERVICE_RISK_MAP.put("ftp", "high");
        SERVICE_RISK_MAP.put("rsh", "high");
        SERVICE_RISK_MAP.put("rlogin", "high");
        
        // Medium risk services
        SERVICE_RISK_MAP.put("http", "medium");
        SERVICE_RISK_MAP.put("http-proxy", "medium");
        SERVICE_RISK_MAP.put("https", "medium");
        SERVICE_RISK_MAP.put("ssh", "medium");
        SERVICE_RISK_MAP.put("smtp", "medium");
        SERVICE_RISK_MAP.put("msrpc", "medium");
        SERVICE_RISK_MAP.put("mysql", "medium");
        SERVICE_RISK_MAP.put("postgresql", "medium");
        SERVICE_RISK_MAP.put("ms-sql", "medium");
        SERVICE_RISK_MAP.put("oracle", "medium");
        SERVICE_RISK_MAP.put("vnc", "medium");
        SERVICE_RISK_MAP.put("rdp", "medium");
        
        // Default for others is "low"
    }

    

    @GetMapping("/scanner")
    public String scannerPage() {
        return "scanner"; // Return the HTML page (scanner.html)
    }

    @PostMapping("/scan")
    public String runNmapScan(@RequestParam("target") String target, 
                              @RequestParam("mode") String mode, 
                              Model model) {
        StringBuilder output = new StringBuilder();
        List<String> vulnerabilities = new ArrayList<>();
        List<Port> portsData = new ArrayList<>();
        
        try {
            // Build the Nmap command dynamically
            List<String> command = new ArrayList<>();
            command.add("nmap");
            command.add("-T4"); // Faster timing
            command.add("-Pn"); // No ping
            
            // Select mode
            switch (mode.toLowerCase()) {
                case "quick":
                    command.add("-F"); // Fast scan, common ports only
                    break;
                case "deep":
                    command.add("--script");
                    command.add("vuln"); // Full vulnerability scripts
                    break;
                case "custom":
                    command.add("-p");
                    command.add("22,80,443,21,23"); // Custom important ports
                    command.add("--script");
                    command.add("vulners"); // Lightweight vulnerability check
                    break;
                default:
                    command.add("-F"); // Default to quick if unknown
            }
            
            command.add(target); // Add target address
            
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean portSectionStarted = false;
            Pattern portPattern = Pattern.compile("(\\d+)/(tcp|udp)\\s+(\\w+)\\s+(.*)");
            
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
                
                // Check if we're in the port listing section
                if (line.contains("PORT") && line.contains("STATE") && line.contains("SERVICE")) {
                    portSectionStarted = true;
                    continue;
                }
                
                // Parse port data
                if (portSectionStarted && !line.trim().isEmpty() && !line.contains("Nmap done:")) {
                    Matcher matcher = portPattern.matcher(line);
                    if (matcher.find()) {
                        String portNumber = matcher.group(1) + "/" + matcher.group(2);
                        String state = matcher.group(3);
                        String service = matcher.group(4).trim();
                        
                        // Determine risk level
                        String riskLevel = SERVICE_RISK_MAP.getOrDefault(service, "low");
                        
                        // Add to ports data
                        portsData.add(new Port(portNumber, state, service, riskLevel));
                    }
                }
                
                // Look for vulnerabilities
                if (line.contains("CVE") || line.toLowerCase().contains("vuln")) {
                    vulnerabilities.add(line.trim());
                }
                
                // End of port section
                if (portSectionStarted && line.contains("Nmap done:")) {
                    portSectionStarted = false;
                }
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                output.append("Nmap exited with code ").append(exitCode);
            }

        } catch (IOException | InterruptedException e) {
            output.append("Error running Nmap: ").append(e.getMessage());
        }

        // Calculate statistics
    long openPorts = portsData.stream().filter(p -> "open".equals(p.getState())).count();
    long filteredPorts = portsData.stream().filter(p -> "filtered".equals(p.getState())).count();
    
    model.addAttribute("scanResults", output.toString());
    model.addAttribute("vulnerabilities", vulnerabilities.isEmpty() 
        ? List.of("No vulnerabilities detected.") 
        : vulnerabilities);
    model.addAttribute("portsData", portsData);
    model.addAttribute("mode", mode);
    model.addAttribute("totalPorts", portsData.size());
    model.addAttribute("openPorts", openPorts);
    model.addAttribute("filteredPorts", filteredPorts);
    
    return "scanner";
    }
}





// Ports 0–1023 → Well-known ports (reserved for standard services like HTTP (80), HTTPS (443), FTP (21), SSH (22), etc.).

// Ports 1024–49151 → Registered ports (for applications, databases, etc.).

// Ports 49152–65535 → Dynamic/private ports (for temporary connections, client-side connections).