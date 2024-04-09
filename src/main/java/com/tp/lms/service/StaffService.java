package com.tp.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.lms.model.Staff;
import com.tp.lms.model.StaffAttendance;
import com.tp.lms.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;

	public List<Staff> GetAllStaff() {
		return staffRepository.findAll();
	}

	public Staff GetStaff(int id) {
		return staffRepository.findById(id).get();
	}

	public Staff AddStaff(Staff staff) {
		return staffRepository.save(staff);
	}

	public Staff UpdateStaff( Staff staff, int id) {
		staff.setStaffId(id);
		return staffRepository.save(staff);
	}

	public void DeleteStaff(int id) {
		staffRepository.deleteById(id);
	}
}
