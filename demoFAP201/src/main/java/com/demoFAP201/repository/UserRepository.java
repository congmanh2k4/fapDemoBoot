/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.repository;

import com.demoFAP201.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LNV
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>{
    @Query("SELECT p FROM User p WHERE p.code = ?1")
    User findByAccountName(String accountName);

}
