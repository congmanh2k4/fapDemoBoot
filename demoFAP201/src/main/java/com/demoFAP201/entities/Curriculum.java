/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Data;

/**
 *
 * @author LNV
 */
@Entity
@Data
public class Curriculum {
    @Id
    private int id;
    private String name;
    
    @OneToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;
    
    @OneToMany(mappedBy = "curriculum")
    private List<Curriculum_Course> curriculumCourse;
    
}
