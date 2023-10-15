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
public class CourseGradeType_Id implements Serializable{
    private int course_id;
    private String grade_type;
    
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof CourseGradeType_Id)) return false;
        CourseGradeType_Id that = (CourseGradeType_Id) o;
        return Objects.equals(course_id, that.getCourse_id())&&
                Objects.equals(grade_type, that.getGrade_type());
        
    }
    @Override
    public int hashCode(){
        return Objects.hash(course_id, grade_type);
    }
    
    
}
