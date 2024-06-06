package com.hsenid.spring_security.service;

import com.hsenid.spring_security.dto.ReqRes;
import com.hsenid.spring_security.model.Users;
import com.hsenid.spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Handles user registration
    public ReqRes signUp(ReqRes registrationRequest) {
        ReqRes reqRes = new ReqRes();
        try {
            // Check if the email is already registered
            if (userRepository.findByEmail(registrationRequest.getEmail()).isPresent()) {
                reqRes.setStatusCode(400);
                reqRes.setMessage("Email is already in use");
                return reqRes;
            }

            // Create a new user object and set its properties
            Users user = new Users();
            user.setEmail(registrationRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            user.setRole(registrationRequest.getRole());

            // Save the user to the database
            Users savedUser = userRepository.save(user);

            // Check if the user was saved successfully
            if (savedUser != null && savedUser.getId() != null) {
                reqRes.setUsers(savedUser);
                reqRes.setMessage("User has been registered successfully");
                reqRes.setStatusCode(200);
            } else {
                reqRes.setStatusCode(500);
                reqRes.setMessage("Failed to register user");
            }

        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setError("Error during registration: " + e.getMessage());
        }
        return reqRes;
    }

    // Handles user login
    public ReqRes signIn(ReqRes signInRequest) {
        ReqRes reqRes = new ReqRes();
        try {
            String email = signInRequest.getEmail();
            String password = signInRequest.getPassword();

            // Check if the user exists in the database
            Optional<Users> userOptional = userRepository.findByEmail(email);
            if (userOptional.isEmpty()) {
                reqRes.setStatusCode(401);
                reqRes.setError("Invalid email");
                return reqRes;
            }

            Users user = userOptional.get();

            // Check if the provided password matches the stored password
            if (!passwordEncoder.matches(password, user.getPassword())) {
                reqRes.setStatusCode(401);
                reqRes.setError("Invalid password");
                return reqRes;
            }

            // Authenticate the user credentials
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

            // Generate JWT and refresh token
            String jwt = jwtUtils.generateToken(user);
            String refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);

            reqRes.setStatusCode(200);
            reqRes.setToken(jwt);
            reqRes.setRefreshToken(refreshToken);
            reqRes.setExpirationTime("24Hr");
            reqRes.setMessage("User has been logged in successfully");

        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setError("Error during login: " + e.getMessage());
        }
        return reqRes;
    }

    // Handles token refresh
    public ReqRes refreshToken(ReqRes refreshTokenRequest) {
        ReqRes reqRes = new ReqRes();
        try {
            String email = jwtUtils.extractUsername(refreshTokenRequest.getToken());
            Users user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

            // Validate the refresh token
            if (jwtUtils.isTokenValid(refreshTokenRequest.getToken(), user)) {
                String newJwt = jwtUtils.generateToken(user);

                reqRes.setStatusCode(200);
                reqRes.setToken(newJwt);
                reqRes.setRefreshToken(refreshTokenRequest.getToken());
                reqRes.setExpirationTime("24Hr");
                reqRes.setMessage("Token has been refreshed successfully");
            } else {
                reqRes.setStatusCode(401);
                reqRes.setMessage("Invalid refresh token");
            }
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setError("Error during token refresh: " + e.getMessage());
        }
        return reqRes;
    }
}
