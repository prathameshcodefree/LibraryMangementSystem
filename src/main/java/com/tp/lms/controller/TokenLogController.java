package com.tp.lms.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import com.tp.lms.model.Staff;
import com.tp.lms.model.TokenLog;
import com.tp.lms.service.TokenLogService;

@RestController
@RequestMapping("/TokenLog")
public class TokenLogController {

	@Autowired
	private TokenLogService tokenLogService;

	@GetMapping
	public List<TokenLog> GetAllTokenLog() {
		return tokenLogService.GetAllToken();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TokenLog> GetStaff(@PathVariable Integer id) {
		try {
			TokenLog tokenLog = tokenLogService.GetTokenLog(id);
			return new ResponseEntity<TokenLog>(tokenLog, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<TokenLog>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public TokenLog AddToken(@RequestBody TokenLog tokenLog) {
		return tokenLogService.AddTokenLog(tokenLog);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TokenLog> Update(@PathVariable Integer id, @RequestBody TokenLog tokenLog) {
		try {
			tokenLogService.UpdateLogToken(tokenLog, id);
			return new ResponseEntity<TokenLog>(tokenLog, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<TokenLog>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void DeleteToken(@PathVariable int id) {
		tokenLogService.DeleteTokenLog(id);
	}
}
