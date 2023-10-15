/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.entities;

import java.util.Objects;
import lombok.Data;

/**
 *
 * @author LNV
 */
@Data
public class StudentSemesterCourse {
    private Student student;
    private Semester semester;
    private Course course;

    public StudentSemesterCourse(Student student, Semester semester, Course course) {
        this.student = student;
        this.semester = semester;
        this.course = course;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        StudentSemesterCourse that = (StudentSemesterCourse) o;
        return (this.course.getId() == that.course.getId())&&
                (this.semester.getId() == that.semester.getId())&&
                (this.student.getId() == that.student.getId());
    }
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 47 * hash + Objects.hash(student);
        hash = 47 * hash + Objects.hash(semester);
        hash = 47 * hash + Objects.hash(course); 
        return hash;
    }
    
}
