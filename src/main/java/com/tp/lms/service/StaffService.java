package com.tp.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.lms.model.Staff;
import com.tp.lms.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository repository;

	public List<Staff> GetAllStaff() {
		return repository.findAll();
	}

	public Staff GetStaff(int id) {
		return repository.findById(id).get();
	}

	public Staff AddStaff(Staff staff) {
		return repository.save(staff);
	}

	public Staff UpdateStaff(Staff staff, int id) {
		staff.setStaffId(id);
		return repository.save(staff);
	}

	public void DeleteStaff(int id) {
		repository.deleteById(id);
	}
}
