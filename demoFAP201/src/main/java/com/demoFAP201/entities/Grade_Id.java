/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.entities;

import java.io.Serializable;
import java.util.Objects;
import lombok.Data;

/**
 *
 * @author LNV
 */
@Data
public class Grade_Id implements Serializable{
    private int student_id;
    private int semester_id;
    private int course_id;
    private String grade_type;
    
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Grade_Id)) return false;
        Grade_Id that = (Grade_Id) o;
        return Objects.equals(student_id, that.student_id)&&
                Objects.equals(semester_id , that.semester_id)&&
                Objects.equals(course_id, that.course_id) &&
                Objects.equals(grade_type, that.grade_type);
    }

    @Override
    public int hashCode() {
       
        return Objects.hash(student_id,semester_id, course_id,grade_type);
    }
    
    
}
