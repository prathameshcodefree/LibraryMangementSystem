package com.tp.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.StaffAttendance;
import com.tp.lms.service.StaffAttendanceService;

@RestController
@RequestMapping("/attendance")
public class StaffAttendanceController {
	
	@Autowired
	StaffAttendanceService service;
	
	@GetMapping
	public ResponseEntity<List<StaffAttendance>> getAllAttendance() {
		     
		return ResponseEntity.ok(service.allAttendance()); 
	
	}
	
	
	
	@GetMapping("{id}")
	public ResponseEntity<StaffAttendance> getById(@PathVariable Integer id )
	
	{	
	
		Optional<StaffAttendance> attendance = service.getAttendanceById(id);
        
		if (attendance.isPresent()) {
       
        	return ResponseEntity.ok(attendance.get());
        
        } else {
        	
            return ResponseEntity.notFound().build();
        
        }
        
	} 
	
	
	@PostMapping
	public ResponseEntity<?> createAttendance(@RequestBody StaffAttendance attendance){
		
		List<String> error = service.validate(attendance);
		
		if (!error.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		
		return ResponseEntity.ok(service.createAttendance(attendance));
	
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAttendance(@PathVariable Integer id ,@RequestBody StaffAttendance attendance )
	
	{
		List<String > error = service.validate(attendance);
		if(!error.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		
        return ResponseEntity.ok(service.updateAttendance(id, attendance));	
      
	}
	
	
   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteAttedance (Integer id )
   
   {
	
	   service.delete(id); 
	   return ResponseEntity.ok("deleted");   

   }
		
}
