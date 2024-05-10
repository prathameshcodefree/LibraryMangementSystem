package com.tp.lms.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.TokenLog;
import com.tp.lms.service.TokenLogService;

@RestController
@RequestMapping("/tokenlog")
public class TokenLogController {

	@Autowired
	TokenLogService tokenLogService;

	@GetMapping(" ")
	public List<TokenLog> getTokenLog() {

		return tokenLogService.getTokenLog();

	}


	@GetMapping("/{id}")
	public ResponseEntity<?> getTokenById(@PathVariable Integer id) {
	    Optional<TokenLog> res = tokenLogService.getTokenLogById(id);
	    if (res.isEmpty()) {
	       
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } else {
	        
	        TokenLog tokenLog = res.get();
	        
	        return ResponseEntity.ok().body(tokenLog);
	    }
	}



	@PostMapping(" ")
	public ResponseEntity<?> addTokenLog(@RequestBody TokenLog tokenLog) {
		List<String> error = tokenLogService.validate(tokenLog);
		if (error.size() != 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		tokenLogService.addLogForStudentLogin(null,0,null,null);
		return ResponseEntity.ok().body("TokenLog added successfully.");

	}


//	@PostMapping(" ")
//	public ResponseEntity<?> addTokenLog(@RequestBody TokenLog tokenLog ) {
//		List<String> error = tokenLogService.validate(tokenLog);
//		if (error.size() != 0) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//		}
//
//		tokenLogService.addLogForStudentLogin(tokenLog);
//		return ResponseEntity.ok().body("TokenLog added successfully.");
//
//	}


	@PutMapping("/{id}")
	public ResponseEntity<?> updateTokenLog(@PathVariable Integer id, @RequestBody TokenLog tokenLog) {
		List<String> error = tokenLogService.validate(tokenLog);
		if (!error.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}

		tokenLogService.updateTokenLog(id,tokenLog);
		return ResponseEntity.ok().body("TokenLog with ID " + id + " Updated successfully.");

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTokenLog(@PathVariable Integer id) {

		boolean deleted = tokenLogService.deleteTokenLog(id);

		if (deleted) {
			return ResponseEntity.ok("TokenLog with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TokenLog with ID " + id + " not found.");
		}

	}

}