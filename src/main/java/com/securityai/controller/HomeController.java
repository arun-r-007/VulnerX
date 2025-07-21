// File: src/main/java/com/securityai/controller/HomeController.java

package com.securityai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // Will render templates/index.html
    }
}
