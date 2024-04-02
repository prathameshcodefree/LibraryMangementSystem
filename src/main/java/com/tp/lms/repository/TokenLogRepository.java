package com.tp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.lms.model.TokenLog;

@Repository
public interface TokenLogRepository extends JpaRepository<TokenLog , Integer> {

}
