package com.tp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.lms.model.AuditColumn;

@Repository
public interface AuditColumnRepository extends JpaRepository<AuditColumn,Integer> {

}
