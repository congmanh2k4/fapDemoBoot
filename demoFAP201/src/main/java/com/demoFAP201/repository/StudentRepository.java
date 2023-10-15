/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.repository;

import com.demoFAP201.entities.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LNV
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    @Query("SELECT p FROM Student p WHERE p.mssv = ?1")
    Optional<Student> findByMssv(String mssv);
}
