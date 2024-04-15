package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tp.lms.model.Rack;
import com.tp.lms.repository.RackRepository;

@Service
public class RackService {


@Autowired	
RackRepository rackRepository;


    public List<Rack> getAllRacks() {
 
    	return rackRepository.findAll();
    }
    
    
    
    public Rack getRackById(Integer id) {
 
    	return rackRepository.findById(id).orElse(null);
    
    }
 
    
    public Rack addRack(Rack rack) {
    	return rackRepository.save(rack);
    }
    

  	 

public List<String> validate(Rack rack) {
	
	System.out.println("we are in valid");
  	 List<String> error = new ArrayList<>();
  	 
  	 if (rack.getId()==null) {
  	
  		 error.add("rack id must be provided ");
  	
  	 }
  	 
  	 
  	 if (rack.getRackCode()==null) {
  	
  		 error.add("rack code must be provided ");
  	 
  	 }
  	 
   	 return error;
   	   	 
   	 }


  	 
    public Rack updateRack(Integer rackId,  Rack rack ) {
    	
    
    	rack.setId(rackId);
    	return rackRepository.save(rack);
    }
    
    
    public void  deleteRack(Integer rackId) {
    	
    	rackRepository.deleteById(rackId);

    } 
    
    
     
   	 
   
    
}
