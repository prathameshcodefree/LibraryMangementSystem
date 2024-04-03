package com.tp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.lms.model.StaffAttendance;

@Repository
public interface StaffAttendanceRepository extends JpaRepository<StaffAttendance,Integer> {

}
