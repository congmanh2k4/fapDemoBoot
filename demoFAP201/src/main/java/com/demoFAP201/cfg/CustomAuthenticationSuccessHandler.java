/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.cfg;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 *
 * @author LNV
 */
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
    throws IOException, ServletException{
        String targetUrl = determineTargetUrl(authentication);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
        
    }
    protected String determineTargetUrl(Authentication authentication){
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for(GrantedAuthority authority : authorities){
            if(authority.getAuthority().equals("ROLE_ADMIN")){
                return "/admin-home";
            } else if( authority.getAuthority().equals("ROLE_LECTURER")){
                return "/lecturer-home";
            } else if( authority.getAuthority().equals("ROLE_STUDENT")){
                return "/student-home";
            }
        }
        return "/login";
    }
}
