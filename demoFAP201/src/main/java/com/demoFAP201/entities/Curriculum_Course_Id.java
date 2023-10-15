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
 * 
 */
@Data
public class Curriculum_Course_Id implements Serializable{
    private int curriculum_id;
    private int course_id;
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Curriculum_Course_Id)) return false;
        Curriculum_Course_Id that = (Curriculum_Course_Id) o;
        return Objects.equals(curriculum_id, that.curriculum_id)&&
                Objects.equals(course_id, that.course_id);
    }
    @Override 
    public int hashCode(){
        return Objects.hash(curriculum_id, course_id);
    }
}
