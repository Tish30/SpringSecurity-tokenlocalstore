package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.Dao.Request.UpdateProfileRequest;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService {
    UserDetailsService userDetailsService();

    void updateProfile(String email, UpdateProfileRequest request);
}
