/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.entities;

import lombok.Data;

/**
 *
 * @author LNV
 * 
 */
@Data
public class StudentAverageGrade {
    private Student student;
    private Semester semester;
    private float averageGrade;

    public StudentAverageGrade(Student student, Semester semester, float averageGrade) {
        this.student = student;
        this.semester = semester;
        this.averageGrade = averageGrade;
    }

    public StudentAverageGrade() {
    }
    
    
}
