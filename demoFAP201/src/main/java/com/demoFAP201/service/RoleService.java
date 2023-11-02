/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.service;

import com.demoFAP201.entities.Role;
import java.util.Optional;

/**
 *
 * @author manhnche
 */
public interface RoleService {
    Optional<Role> findRoleById(int id);
}
