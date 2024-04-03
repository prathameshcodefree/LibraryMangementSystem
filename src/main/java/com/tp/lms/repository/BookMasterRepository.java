package com.tp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.lms.model.BookMaster;


/**
 * 
 * 
 @author DURGESH */

@Repository
public interface BookMasterRepository extends JpaRepository<BookMaster,Integer> {

}
