/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author LNV
 */
@Entity
@Data
@IdClass(Curriculum_Course_Id.class)
public class Curriculum_Course {
    @Id
    private int curriculum_id;
    @Id
    private int course_id;
    private int term;
    
    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;
    
    @ManyToOne
    @JoinColumn(name = "curriculum_id", insertable = false, updatable = false)
    private Curriculum  curriculum;
}
