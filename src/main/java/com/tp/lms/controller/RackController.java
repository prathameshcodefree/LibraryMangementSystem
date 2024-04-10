package com.tp.lms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.Rack;
import com.tp.lms.service.RackService;


@RestController
@RequestMapping("/racks")

public class RackController {
	
	@Autowired
	RackService rackService;
	
	    @GetMapping
	    public List<Rack> getAllRacks() {
	        return rackService.getAllRacks();
	    }

	    @GetMapping("/{id}")
	    public Rack getRackById(@PathVariable Integer id) {
	        return rackService.getRackById(id);
	    }
	    
	    @PostMapping("")
	    public Rack addRack(Rack rack) {
	    	
	    	return rackService.addRack(rack);
         
         }
	    
	    @PutMapping("/{id}")
	    public Rack updateRack(Integer rackId,@RequestBody Rack rack) {
	    	
	    	return rackService.updateRack(rackId, rack);
	    }
	    
	    
	    @DeleteMapping("/{id}")
	    public void deleteRack(Integer rackId) {
	    	
	    	rackService.deleteRack(rackId);
	    }
	    

}
