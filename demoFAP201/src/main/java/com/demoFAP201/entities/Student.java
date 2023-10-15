/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.entities;

import com.demoFAP201.json.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

/**
 *
 * @author LNV
 */
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private int id;
    
    @JsonView(Views.InternalStudent.class)
    private String name;
    
    @JsonView(Views.InternalStudent.class)
    private String mssv;
    
    @JsonView(Views.Public.class)
    private LocalDate dob; // date of birth
    
    @JsonView(Views.Public.class)
    private boolean gender;
    
    
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;
    
    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToMany(mappedBy = "students")
    private List<LearnGroup> groups;
    
}
