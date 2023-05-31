package com.example.jpasecurity.config;

import com.example.jpasecurity.service.JpaUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JpaUserDetailService jpaUserDetailService;

    public SecurityConfig(JpaUserDetailService jpaUserDetailService) {
        this.jpaUserDetailService = jpaUserDetailService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                .authorizeRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/api/posts/**").permitAll()
                        .anyRequest().authenticated()
                )
                .userDetailsService(jpaUserDetailService)
                .headers(headers -> headers.frameOptions().sameOrigin())
                .formLogin(withDefaults())
                .build();
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
