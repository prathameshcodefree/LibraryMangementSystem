package com.tp.lms.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.lms.model.Requirement;



@Repository
public interface RequirementRepository extends JpaRepository<Requirement , Integer>{



}
