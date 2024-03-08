package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.Dao.JwtAuthenticationResponse;
import com.example.SpringSecurity.Dao.Request.Signin;
import com.example.SpringSecurity.Dao.Request.Signup;
import com.example.SpringSecurity.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;



@Controller
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    // GET request mapping for showing the login form
    @GetMapping("/signup")
    public String showSignupForm() {
        return "Register.html"; // Return the name of your Thymeleaf HTML file
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@ModelAttribute Signup request) {
        System.out.println(request);
        return ResponseEntity.ok(authenticationService.signup(request));
    }
    @GetMapping("/signin")
    public String showSigninForm() {
        return "Login.html"; // Return the name of your Thymeleaf HTML file
    }

//    @PostMapping("/signin")
//    public ResponseEntity<JwtAuthenticationResponse> signin(@ModelAttribute Signin request) {
//        System.out.println(request);
//        return ResponseEntity.ok(authenticationService.signin(request));
//    }


    @PostMapping("/signin")
    public RedirectView signin(@ModelAttribute Signin request, RedirectAttributes redirectAttributes) {
        JwtAuthenticationResponse response = authenticationService.signin(request);
        if (response != null && response.getToken() != null) {
            // Add a flash attribute to pass the token to the home page
            redirectAttributes.addFlashAttribute("token", response.getToken());
            return new RedirectView("/api/v1/auth/home"); // Redirect to the home page
        } else {
            // Handle unsuccessful login
            return new RedirectView("/signin?error"); // Redirect to the signin page with an error parameter
        }
    }

    @GetMapping("/home")
    public String showHome() {
        return "Home.html"; // Return the name of your Thymeleaf HTML file
    }

    @PostMapping("/home")
    public String home() {
        return "Home.html"; // Return the name of your Thymeleaf HTML file
    }



}