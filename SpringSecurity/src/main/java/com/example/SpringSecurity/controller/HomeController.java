package com.example.SpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/auth")
@Controller
public class HomeController {
    @GetMapping("/product")
    public String products() {
        return "product.html";
    }
@GetMapping("/notification")
    public String notificaations() {
        return "notification.html";
    }

    @GetMapping("/contact")
public String contact() {
        return "contact.html";
    }

    @GetMapping("/trial")
    public String trial() {
        return "trial.html";
    }
}
