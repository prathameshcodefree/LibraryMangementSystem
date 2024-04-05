package com.tp.lms.service;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tp.lms.model.Staff;
import com.tp.lms.model.StaffAttendance;
import com.tp.lms.repository.StaffAttendanceRepository;

@Service
public class StaffAttendanceService {
 
    @Autowired
	StaffAttendanceRepository staffAttendanceRepository;
    
    
    // get all Attendance 
    public List<StaffAttendance> allAttendance()
    {
		
		return staffAttendanceRepository.findAll();
    
    }
     
    // get Attendance by Id 
   
    
   public Optional<StaffAttendance> getAttendanceById(Integer id)
   {
 
	   return staffAttendanceRepository.findById(id);
   
   }
   
    
    // create Attendance 
   
	 public StaffAttendance createAttendance(StaffAttendance attendance )
	 {
	 
		 return staffAttendanceRepository.save(attendance);			
		
	 }
	
	 
	 //update Attendance
	  public StaffAttendance updateAttendance( Integer  id, StaffAttendance attendance  )
	  {
		  
		StaffAttendance sRef  = staffAttendanceRepository.getReferenceById(id);
		
		if (sRef == null) return null ;
		 
		return staffAttendanceRepository.save(attendance);
		 
	 }
	 
	 // deleting Attendance by Id 
	 
	 public void delete(Integer id ) 
	 
	 {
		 
		 staffAttendanceRepository.deleteById(id);
	
	 }
	 
	
	 // validation method  
	 
	 public List<String> validate(StaffAttendance staffattendance) {
	 List<String> error = new ArrayList<>();
	 
	 if (staffattendance.getCheckIn()==null) {
	
		 error.add("check-in date must be provided ");
	 }
	 
	 if (staffattendance.getCheckOut()==null) {
	
		 error.add("check-out date must be provided ");
	 }
	 
	 if (staffattendance.getId()==0) {
		
		 error.add("Id must be provided in number");
	
	 }
	 
	 if(staffattendance.getPresenty()==null) {
		
		 error.add("presence status must be provided ");
	 
	 }
	 
	 
	 return error;
	 
	 
	 }
	 
}
