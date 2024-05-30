package com.javastudy.cashbook.handler;

import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MemberFailureHandler extends SimpleUrlAuthenticationFailureHandler{

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        
        String errMsg="";
        if (exception instanceof BadCredentialsException) {
            errMsg+="\nYour ID or password is incorrect.";
        }else{
            errMsg+="\nLogin failed. Please retry or contacr the administrator.";
        }
        errMsg = URLEncoder.encode(errMsg, "UTF-8");
        
        setDefaultFailureUrl("/login?error=true&errMessage="+errMsg);
        
        super.onAuthenticationFailure(request, response, exception);
    }
    
    
}
