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
@IdClass(Grade_Id.class)
public class Grade {
    @Id
    private int student_id;
    @Id
    private int semester_id;
    @Id
    private int course_id;
    @Id
    private String grade_type;
    private float value;

    public Grade(int student_id, int semester_id, int course_id, String grade_type, float value) {
        this.student_id = student_id;
        this.semester_id = semester_id;
        this.course_id = course_id;
        this.grade_type = grade_type;
        this.value = value;
    }

    public Grade() {
    }
    
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "semester_id", insertable = false, updatable = false)
    private Semester semester;
    
    @ManyToOne
    @JoinColumn(name = "course", insertable = false, updatable = false)
    private Course course;
    
    
    
    
}
