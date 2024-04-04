package com.tp.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    
    
    public Rack updateRack(Integer rackId, @RequestBody Rack rack ) {
    	
    	rack.setId(rackId);
    	return rackRepository.save(rack);
    }
    
    
    public void deleteRack(Integer rackId) {
    	
    	rackRepository.deleteById(rackId);

    } 
   
    
}
