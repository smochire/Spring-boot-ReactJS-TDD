package com.heriniaina.data.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface AuthenticationProviderService {
    AuthenticationProvider getAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder);
}
