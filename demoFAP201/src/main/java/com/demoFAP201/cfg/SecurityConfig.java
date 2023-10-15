/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

/**
 *
 * @author LNV
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    UserDetailsService uds;
    
    @Autowired
    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    
    
    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(uds);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }
    
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector){
        return new MvcRequestMatcher.Builder(introspector).servletPath("/DemoFap201Application/");
        
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc)throws Exception{
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth->{
                    auth
                            .requestMatchers(antMatcher("/profile")).authenticated()
                            .requestMatchers(antMatcher("/admin/**")).hasAuthority("USER_ADMIN")
                            .requestMatchers(antMatcher("/students/**")).hasAnyAuthority("USER_STUDENT", "USER_ADMIN")
                            .requestMatchers(antMatcher("/lecturer/**")).hasAnyAuthority("USER_LECTURER","USER_ADMIN")
                            .anyRequest().permitAll();
                })
                .formLogin(formLogin -> {
                                formLogin.loginPage("/login").permitAll()
                                        .loginProcessingUrl("/login-process")
                                        .successHandler(customAuthenticationSuccessHandler)
                                        .failureUrl("/login?error=true");
                })
                .exceptionHandling(ex->ex.accessDeniedPage("/403"))
                .logout(logout->logout.invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(antMatcher("/logout"))
                        .logoutSuccessUrl("/login")
                        .permitAll()
                );
                return http.build();          
    }
    
}
