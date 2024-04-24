package com.tp.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.lms.model.Student;
import com.tp.lms.model.TokenLog;

/**
 * 
 * 
 @author DURGESH */

@Repository
public interface TokenLogRepository extends JpaRepository<TokenLog , Integer> {

	Optional<TokenLog> findByToken(String token);

	Optional<TokenLog> findFirstByToken(String token);


}
