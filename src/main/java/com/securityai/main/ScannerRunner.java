package com.securityai.main;

import java.util.List;

import com.securityai.scanner.BannerGrabber;
import com.securityai.scanner.VulnerabilityScanner;

public class ScannerRunner {
    public static void main(String[] args) {
        String host = "127.0.0.1"; // Replace with target IP
        int startPort = 75;
        int endPort = 85;

        VulnerabilityScanner scanner = new VulnerabilityScanner();
        BannerGrabber grabber = new BannerGrabber();

        List<Integer> openPorts = scanner.scanOpenPorts(host, startPort, endPort, 500);

        for (int port : openPorts) {
            grabber.grabBanner(host, port);
        }
    }
}
