package com.tp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tp.lms.model.Staff;
import com.tp.lms.model.StaffAttendance;

@Repository
public interface StaffRepository extends JpaRepository<StaffAttendance, Integer> {

}
