/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.service.impl;

import com.demoFAP201.entities.Role;
import com.demoFAP201.repository.RoleRepository;
import com.demoFAP201.service.RoleService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manhnche
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository rolerp;

    @Override
    public Optional<Role> findRoleById(int id) {
        return rolerp.findById(id);
    }
    
}
