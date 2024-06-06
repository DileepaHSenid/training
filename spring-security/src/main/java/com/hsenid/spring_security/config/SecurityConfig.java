package com.hsenid.spring_security.config;

import com.hsenid.spring_security.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JWTAuthFilter jwtAuthFilter;

    // Define the security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configure HTTP security
        http.csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection
                .authorizeHttpRequests(requests -> requests
                        // Define which endpoints are publicly accessible
                        .requestMatchers("/home", "/signin", "/signup").permitAll()
                        // Define role-based access control for specific endpoints
                        .requestMatchers("/manage").hasAuthority("ADMIN")
                        .requestMatchers("/products").hasAuthority("USER")
                        .requestMatchers("/dashboard").hasAnyAuthority("ADMIN", "USER")
                        // Require authentication for any other request
                        .anyRequest().authenticated())
                // Configure session management to be stateless
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Add JWT authentication filter before the default UsernamePasswordAuthenticationFilter
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    // Define the authentication provider
    @Bean
    public AuthenticationProvider authenticationProvider() {
        // Use DaoAuthenticationProvider to authenticate users with user details service and password encoder
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    // Define the password encoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Use BCryptPasswordEncoder to encode passwords
        return new BCryptPasswordEncoder();
    }

    // Define the authentication manager bean
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        // Get the authentication manager from the authentication configuration
        return authenticationConfiguration.getAuthenticationManager();
    }
}
