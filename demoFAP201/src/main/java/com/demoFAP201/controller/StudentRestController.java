/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.controller;

import com.demoFAP201.entities.Student;
import com.demoFAP201.json.Views;
import com.demoFAP201.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LNV
 */
@RestController
@RequestMapping("/student/home")
public class StudentRestController {
    @Autowired
    StudentService svc;

    @GetMapping("/students")
    public ResponseEntity<Object> list()throws JsonProcessingException{
        Iterable<Student> list = svc.findAllStudents();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String result = mapper.writerWithView(Views.Public.class).writeValueAsString(list);
        return ResponseEntity.ok(mapper.readTree(result));
    }
    
    @PostMapping("/students")
    public ResponseEntity<Map<String,Object>> add( @RequestBody Student student){
        Map<String, Object> statusJson = new HashMap<>();
        try {
            svc.saveStudent(student);
            statusJson.put("code", "200");
            statusJson.put("message", "Student inserted successfully.");
            statusJson.put("data", student);
        } catch (Exception e) {
            String fullMessage = e.getMessage();
            statusJson.put("code", "500");
            statusJson.put("message", String.format("Fail to up date student: \nReason: %s", fullMessage));
            
        }
        return ResponseEntity.ok(statusJson);
    }
    
    @GetMapping("/students/{mssv}")
    public ResponseEntity<Object> get(@PathVariable String mssv) throws JsonProcessingException{
        Map<String,Object> statusJson = new HashMap<>();
        Optional<Student> std = svc.findStudentByMssv(mssv);
        if(!std.isPresent()){
            statusJson.put("code", "404");
            statusJson.put("message", String.format("Student with mssv: %s can't be found ", mssv));
            return ResponseEntity.ok(statusJson);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String result = mapper.writerWithView(Views.Public.class).writeValueAsString(std.get());
        return ResponseEntity.ok(mapper.readTree(result));
    }
    
    @PutMapping("/students/{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable int id, @RequestBody Student newStudent){
        Map<String, Object> statusJson = new HashMap<>();
        Optional<Student> std = svc.findStudentById(id);
        if(!std.isPresent()){
            statusJson.put("code", "404");
            statusJson.put("message", String.format("Studen with id: '%d' can't be found to update.", id));
            return ResponseEntity.ok(statusJson);
        }
        
        try {
            Student t = std.get();
            t.setDob(newStudent.getDob());
            t.setName(newStudent.getName());
            t.setMssv(newStudent.getMssv());
            t.setGender(newStudent.isGender());
            svc.saveStudent(t);
            statusJson.put("code", "200");
            statusJson.put("message", "Student update successfully.");
            statusJson.put("data", t);
        } catch (Exception e) {
            statusJson.put("code", "500");
            statusJson.put("message", String.format("Fail to update student. \nReason: %s",e.getMessage()));
            
        }
        
        return ResponseEntity.ok(statusJson);
    }
    
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String,Object>> delete(@PathVariable int id){
        Optional<Student> std = svc.findStudentById(id);
        Map<String, Object> statusJson = new HashMap<>();
        if(!std.isPresent()){
            statusJson.put("code", "404");
            statusJson.put("message", String.format("Student with id: '%d' can't be found to delete.", id));
            return ResponseEntity.ok(statusJson);
        }
        
        try {
            Student t = std.get();
            svc.deleteStudent(t);
            statusJson.put("code", "200");
            statusJson.put("message", "Student deleted successfully.");
            
        } catch (Exception e) {
            statusJson.put("code", "500");
            statusJson.put("message", String.format("Fail to delete student. \nReason: %s",e.getMessage()));
            
        }
        return ResponseEntity.ok(statusJson);
    }
    
}
