/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author LNV
 */
@Entity
@Data
public class Dept {
    @Id
    private int id;
    private String name;
    private String engName;
    
    @OneToOne
    @JoinColumn(name = "major_id")
    private Major major;
    
}
