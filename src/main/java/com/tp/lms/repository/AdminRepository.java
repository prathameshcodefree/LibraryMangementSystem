/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.lms.repository;

import com.tp.lms.model.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Suhail Tamboli
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    
}
