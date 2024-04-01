/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.lms.controller;

import com.tp.lms.model.Admin;
import com.tp.lms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Suhail Tamboli
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    
    @Autowired
    AdminService adminService;
    
    @PostMapping
    public ResponseEntity<Object> createAdmin(@RequestBody Admin admin) {
        if (admin.getEmail() == null || admin.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required");
        }
        admin = adminService.create(admin);
        return ResponseEntity.ok(admin);
    }
    
}
