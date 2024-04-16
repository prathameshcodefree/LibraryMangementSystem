package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tp.lms.model.Staff;
import com.tp.lms.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	StaffRepository staffRepository;

	public List<Staff> getStaff() {

		return staffRepository.findAll();

	}

	public Optional<Staff> getStaffById(Integer id) {
		return staffRepository.findById(id);

	}

	public List<String> validate(Staff staff) {
		
		boolean isEmail = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
				.matcher(staff.getEmail()).matches();
		
		boolean isPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d@$!%*?&]{8,}$"
				+ "")
				.matcher(staff.getPassword()).matches();

		List<String> error = new ArrayList<>();

//		if (staff.getId() == null) {
//			error.add("Id can not be empty");
//		}

		if (staff.getEmail() == null) {
			error.add("Staff Email can not be empty");
		}
		if (!isEmail) {
			error.add("email is not correct");
		}
		if(staff.getPassword()== null) {
			   error.add("Staff Password Can Not Be Empty");
			}
		if (!isPassword) {
			error.add("Staff password can not be empty");
		}
		
      
		if (staff.getFirstName() == null) {
			error.add("Staff FirstName can not be empty");
		}
		if (staff.getMiddleName() == null) {
			error.add("Staff Middle name can not be empty");
		}
		if (staff.getLastName() == null) {
			error.add("Staff LastName can not be empty");
		}
		if (staff.getContactNumber() ==0) {
			error.add("Staff Contact Number can not be empty");
		}
		if (staff.getAadhaarNumber() == 0) {
			error.add("Staff AadharNumber Number can not be empty");
		}

		if (staff.getGender() == null) {
			error.add("Staff Gender can not be empty");
		}

		if(staff.getStaffType()== null) {
		   error.add("Staff Type Can Not Be Empty");
		}
		if(staff.getDob()== null) {
			   error.add("Staff DOB Can Not Be Empty");
			}

		return error;
	}

	public Staff addStaff(Staff staff) {

		return staffRepository.save(staff);

	}

	public Staff UpdateStaff( Staff staff, int id) {
		staff.setStaffId(id);

		return staffRepository.save(staff);}

	public Staff updateStaff(Integer id, @RequestBody Staff staff) {
		Staff existingStaff = staffRepository.findById(id).orElse(null);
		existingStaff.setStaffId(staff.getId());
		existingStaff.setFirstName(staff.getFirstName());
		existingStaff.setMiddleName(staff.getMiddleName());
		existingStaff.setLastName(staff.getLastName());
		existingStaff.setGender(staff.getGender());
		existingStaff.setContactNumber(staff.getContactNumber());
		existingStaff.setAadhaarNumber(staff.getAadhaarNumber());
		existingStaff.setStaffType(staff.getStaffType());
		existingStaff.setStaffStatus(staff.getStaffStatus());
		existingStaff.setDob(staff.getDob());
		existingStaff.setPassword(staff.getPassword());
		
		return staffRepository.save(existingStaff);

	

	}

	public boolean deleteStaff(Integer id) {

		boolean exists = staffRepository.existsById(id);
		if (exists) {
			staffRepository.deleteById(id);
			return true;
		} else {

			return false;
		}

	}}

