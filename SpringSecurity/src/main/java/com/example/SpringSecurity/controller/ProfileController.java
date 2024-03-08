package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.Dao.Request.UpdateProfileRequest;
import com.example.SpringSecurity.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;

    @PutMapping("/profile")
    public ResponseEntity<String> updateProfile(@RequestBody UpdateProfileRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName(); // Get the email from the authenticated user
        userService.updateProfile(userEmail, request);
        return ResponseEntity.ok("Profile updated successfully");
    }
}
