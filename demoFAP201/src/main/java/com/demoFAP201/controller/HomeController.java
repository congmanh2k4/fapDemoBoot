/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author manhnche
 */
@Controller
public class HomeController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/admin-home")
    public String adminHome() {
        return "admin-home";
    }
    
    
    @GetMapping("/lecturer-home")
    public String lecturerHome() {
        return "lecturer-home";
    }
    @GetMapping("/student-home")
    public String studentHome() {
        return "student-home";
    }
}    


