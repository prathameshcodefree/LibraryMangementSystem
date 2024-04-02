package com.tp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tp.lms.model.Rack;

@Repository
public interface RackRepository extends JpaRepository<Rack, Integer> {

}
