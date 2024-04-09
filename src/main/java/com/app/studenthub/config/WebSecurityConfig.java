package com.app.studenthub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import com.app.studenthub.config.CustomAuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        System.out.println("Configuring WebSecurityConfig");

        http
                .authorizeRequests(authz -> authz
                        .requestMatchers("/login/oauth2/code/*").permitAll()
                        .anyRequest().authenticated() // Require authentication for any other request
                )
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login-failed")
                        .successHandler(customAuthenticationSuccessHandler)

                );
        return http.build();
    }

    // Other beans like UserDetailsService and PasswordEncoder can also be defined here if needed
}
