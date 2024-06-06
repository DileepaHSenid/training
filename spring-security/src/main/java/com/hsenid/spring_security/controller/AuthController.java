package com.hsenid.spring_security.controller;

import com.hsenid.spring_security.dto.ReqRes;
import com.hsenid.spring_security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private AuthService authService;

    // Endpoint to handle user signup
    @PostMapping("/signup")
    public ResponseEntity<ReqRes> signUp(@RequestBody ReqRes signUpRequest) {
        // Delegate the signup request to AuthService and return the response
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    // Endpoint to handle user signin
    @PostMapping("/signin")
    public ResponseEntity<ReqRes> signIn(@RequestBody ReqRes signInRequest) {
        // Delegate the signin request to AuthService and return the response
        return ResponseEntity.ok(authService.signIn(signInRequest));
    }

    // Endpoint to handle token refresh
    @PostMapping("/refresh")
    public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes refreshTokenRequest) {
        // Delegate the refresh token request to AuthService and return the response
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }
}
