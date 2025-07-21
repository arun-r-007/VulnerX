package com.securityai.scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class BannerGrabber {

    public String grabBanner(String host, int port) {
        String banner = "";

        try (Socket socket = new Socket(host, port)) {
            socket.setSoTimeout(2000); // 2 sec timeout

            OutputStream out = socket.getOutputStream();
            out.write("HEAD / HTTP/1.0\r\n\r\n".getBytes()); // Simple HTTP request
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }

            banner = response.toString();
            System.out.println("Banner for port " + port + ":\n" + banner);

        } catch (IOException e) {
            System.out.println("Could not grab banner on port " + port + ": " + e.getMessage());
        }

        return banner;
    }
}
