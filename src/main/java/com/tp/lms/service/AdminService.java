/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.lms.service;

import com.tp.lms.model.Admin;
import com.tp.lms.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Suhail Tamboli
 */
@Service
public class AdminService {
    
    @Autowired
    AdminRepository adminRepository;
    
    public Admin create(Admin admin) {
        
        admin = adminRepository.save(admin);
        return admin;
    }
}
