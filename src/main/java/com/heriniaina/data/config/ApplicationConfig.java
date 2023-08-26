package com.heriniaina.data.config;

import com.heriniaina.data.service.AuthenticationProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final AuthenticationProviderService authenticationProviderService;

    private final UserDetailsService userDetailsService;

    @Bean
    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider() {
        return authenticationProviderService.getAuthenticationProvider(getUserDetailsService(), getPasswordEncoder());
    }

    @Bean
    public AuthenticationManager getAuthenticaticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
