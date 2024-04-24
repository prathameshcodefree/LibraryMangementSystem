package com.tp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.lms.model.Token;

public interface TokenRepository extends JpaRepository<Token,Long> {

	Token findByToken(String token);

}
