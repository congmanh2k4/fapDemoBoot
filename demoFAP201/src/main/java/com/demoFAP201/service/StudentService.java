/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.service;

import com.demoFAP201.entities.Student;
import java.util.Optional;

/**
 *
 * @author LNV
 */
public interface StudentService {
    Optional<Student> findStudentById(int studentId);
    
    Optional<Student> findStudentByMssv(String mssv);
    
    Iterable<Student> findAllStudents();
    
    void deleteStudent(Student std);
    
    Student saveStudent(Student std);

    
}
