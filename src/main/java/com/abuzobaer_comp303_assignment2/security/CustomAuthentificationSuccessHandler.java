package com.abuzobaer_comp303_assignment2.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class CustomAuthentificationSuccessHandler implements AuthenticationSuccessHandler {

    public static final String ROLE_ADMIN="ROLE_admin";
    SimpleUrlAuthenticationSuccessHandler userSuccessHandler=new SimpleUrlAuthenticationSuccessHandler("/personnel");

    SimpleUrlAuthenticationSuccessHandler adminSuccessHandler=new SimpleUrlAuthenticationSuccessHandler("/home");

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            this.adminSuccessHandler.onAuthenticationSuccess(request,response,authentication);

    }
}
