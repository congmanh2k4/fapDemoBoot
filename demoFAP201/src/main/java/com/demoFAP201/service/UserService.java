/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.service;

import com.demoFAP201.entities.User;
import java.util.Optional;

/**
 *
 * @author manhnche
 */
public interface UserService {
    Optional<User> findUserById(String userId);
    Iterable<User> findAllUser();
    void deleteUser(User user);
    User saveUser(User user);
}
