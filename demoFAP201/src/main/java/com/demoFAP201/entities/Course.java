/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

/**
 *
 * @author LNV
 */
@Entity
@Data
public class Course {
    @Id
    private int id;
    
    private String name;
    private String shortName;
    private int credit;
    
    @OneToMany(mappedBy = "course")
    private List<Curriculum_Course> curriculumCourse;
    
    
}
