/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demoFAP201.service.impl;

import com.demoFAP201.entities.User;
import com.demoFAP201.repository.UserRepository;
import com.demoFAP201.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manhnche
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository usrp;
    @Override
    public Optional<User> findUserById(String userId) {
        return usrp.findById(userId);
    }

    @Override
    public Iterable<User> findAllUser() {
        return usrp.findAll();
    }

    @Override
    public void deleteUser(User user) {
        usrp.delete(user);
    }

    @Override
    public User saveUser(User user) {        
        return usrp.save(user);
    }
    
}
