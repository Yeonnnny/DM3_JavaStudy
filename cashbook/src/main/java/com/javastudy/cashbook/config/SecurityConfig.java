package com.javastudy.cashbook.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.javastudy.cashbook.handler.MemberFailureHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final MemberFailureHandler failuerHandler;

    @Value("${server.servlet.context-path}")
    String contextPath;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        
        // permitAll
        http.authorizeHttpRequests((auth)->auth.requestMatchers("/",
            "/join",
            "/join/isExistId", //회원가입 시 아이디 존재여부 확인
            "/joinProc",
            "/login",
            "/script").permitAll()
            .anyRequest().authenticated());

        // Login
        http.formLogin((auth)->auth.loginPage("/login")
                .usernameParameter("memberId")
                .passwordParameter("memberPw")
                .failureHandler(failuerHandler)
                .defaultSuccessUrl("/")
                .loginProcessingUrl("/loginProc")
                .permitAll());
        
        // Logout
        http.logout((auth)->auth.logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID"));
        
        // CSRF(Cross-Site Request Forgery) 비활성화
        http.csrf((auth)->auth.disable());

        return http.build();
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
