package com.tp.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.lms.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	

	Optional<Student> findByUserName(String userName);
	
}
