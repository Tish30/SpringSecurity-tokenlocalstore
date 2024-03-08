package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.Dao.JwtAuthenticationResponse;
import com.example.SpringSecurity.Dao.Request.Signin;
import com.example.SpringSecurity.Dao.Request.Signup;
import org.springframework.stereotype.Service;

public interface AuthenticationService {

    JwtAuthenticationResponse signup(Signup request);

    JwtAuthenticationResponse signin(Signin request);

}
