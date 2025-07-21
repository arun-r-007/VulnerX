package com.securityai.service;  // Package name

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class NmapScanService {

    public String executeNmapScan(String target) {
        String result = "";
        try {
            // Build the command to run
            String command = "nmap -Pn " + target;
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            Process process = processBuilder.start();

            // Capture the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line + "\n";
            }

            // Wait for the process to finish
            process.waitFor();

        } catch (Exception e) {
            result = "Error executing Nmap: " + e.getMessage();
        }

        return result;
    }
}
