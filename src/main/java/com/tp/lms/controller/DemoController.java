package com.tp.lms.controller;


import java.util.List;
import java.util.Optional;

import org.aspectj.lang.Aspects14;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.Staff;
import com.tp.lms.model.Student;
import com.tp.lms.repository.StaffRepository;
import com.tp.lms.service.StaffService;




@RestController
@RequestMapping("demo")
public class DemoController {
	
	@Autowired
	StaffRepository repository;
	
	@GetMapping("check")
	public String getDemo(@RequestParam String user,@RequestParam String password) {
		
		
		return "HELLO "+ user + password;
	}
	@GetMapping("test")
	public String sayHello() {
		
		return "Hello ghhgng";
	}
	
	
	@GetMapping("/test1")
	public Student test2() {
		Student s = new Student();
		s.setFirstName("Rahul");
		s.setContactNumber("9930854589");
		s.setEmail("rahulmaurya1500");
		s.setLastName("maurya");
		
	return s;
	
	}

	 
	@PostMapping("test2")
	public String librarianCredentials(@RequestBody Staff staff) {
		final String librarianEmai = "rahulmaurya1500@gmail.com";
		final String librarianPassword = "password@123";
		 
		 if (librarianEmai.equals(staff.getEmail())&& librarianPassword.equals(staff.getPassword()))
		 {
			  
			 return "Authendicated";	 
			 
		 }
		 
		 
		 return "invalid credentials ";

	}
	
	@PostMapping("test3")
	public String Stafflogin (@RequestBody Staff staff) {
	
		Staff  s1= repository.getReferenceById(staff.getId());
		
		if (s1==null ) { return "invalid id  ";}
		if (s1.getEmail().equals(staff.getEmail())&& s1.getPassword().equals(staff.getPassword())){
			return "Authenticated ";
		}
		
		
		return "invalid credentials";
	
	}
	
	
	
	@PostMapping("")
	public Staff DemoAddStaff(@RequestBody Staff staff) {
		Staff s = repository.save(staff);
	
		return s;
	
	}



}
