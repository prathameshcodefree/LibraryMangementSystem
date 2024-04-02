package com.tp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.lms.model.RequirementBook;


@Repository
public interface RequirementBookRepository extends JpaRepository<RequirementBook,Integer> {

}
