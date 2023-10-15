/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.service.impl;

import com.demoFAP201.entities.Student;
import com.demoFAP201.repository.StudentRepository;
import com.demoFAP201.service.StudentService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LNV
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository stdrepo;
    
    
    @Override
    public Optional<Student> findStudentByMssv(String mssv) {
        return stdrepo.findByMssv(mssv);
    }

    @Override
    public Iterable<Student> findAllStudents() {
        return stdrepo.findAll();
    }

    @Override
    public void deleteStudent(Student std) {
        stdrepo.delete(std);
    }

    @Override
    public Student saveStudent(Student std) {
        return stdrepo.save(std);
    }

    @Override
    public Optional<Student> findStudentById(int studentId) {
        return stdrepo.findById(studentId);
    }
    
}
