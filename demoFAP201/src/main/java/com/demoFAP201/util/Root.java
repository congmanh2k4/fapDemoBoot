/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.util;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author manhnche
 */
public class Root {
    public static String get(HttpServletRequest req, String extraURL){
        
        ServletContext context = req.getServletContext();
        String contextPath = context.getContextPath();
        return contextPath + "/" + extraURL;
        
    }
}
