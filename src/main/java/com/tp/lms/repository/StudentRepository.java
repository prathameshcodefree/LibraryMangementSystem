package com.tp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.lms.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	

}
