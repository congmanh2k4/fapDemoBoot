/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.controller;

import com.demoFAP201.entities.Role;
import com.demoFAP201.entities.Student;
import com.demoFAP201.entities.User;
import com.demoFAP201.service.RoleService;
import com.demoFAP201.service.StudentService;
import com.demoFAP201.service.UserService;
import com.demoFAP201.util.Root;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author manhnche
 */
@Controller
@RequestMapping("/admin-home")
public class StudentController {
    
    
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(5);
    
    @Autowired
    RoleService rsc;
    @Autowired
    StudentService svc;
    
    @Autowired
    UserService usc;
    
    
    @GetMapping("/students")
    public ModelAndView list(){
       Iterable<Student> list = svc.findAllStudents();
       ModelAndView mv = new ModelAndView();
       mv.setViewName("list-student");
       mv.addObject("studentList", list);
       return mv;     
    }
    
    @GetMapping("/student/add")
    public ModelAndView addPage(){      
       ModelAndView mv = new ModelAndView();
       mv.setViewName("add-student");
       return mv;     
    }
    @PostMapping("/student/add")
    public RedirectView add(HttpServletRequest req){
        try {
            
        
        Student std = new Student();
        std.setName(req.getParameter("name"));
        std.setMssv(req.getParameter("mssv"));
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        std.setDob(LocalDate.parse(req.getParameter("dob"), pattern));
        std.setGender(Boolean.parseBoolean(req.getParameter("gender")));
        
        
        Optional<Role> role = rsc.findRoleById(3);
        User user = new User();
        user.setCode(req.getParameter("username"));
        String rawPassword = req.getParameter("password");
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);         
        user.setRole(role.get());
        User newUser = usc.saveUser(user);
        std.setUser(newUser);
        svc.saveStudent(std);
            
        return new RedirectView(Root.get(req, "admin-home/students"));
    
    } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("lỗi trong quá trình thêm sinh viên",e);
            return new RedirectView(Root.get(req, "error"));
        }
    }    
    
}
