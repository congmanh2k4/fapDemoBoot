/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author LNV
 */
@Entity
@Data
public class User {
    @Id
    private String code;
    
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    
    @OneToOne(mappedBy = "user")
    private Lecturer lecturer;
    
    @OneToOne(mappedBy = "user")
    private Student student;
    
    
}
