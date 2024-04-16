package com.tp.lms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.Login;

@RestController
@RequestMapping("security")
public class LoginController {
		

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login loginForm) {
        // Extract username and password from the loginForm object
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        System.out.println(username);

        // Implement your authentication logic here
        // For example, check against a database or any other authentication mechanism
        if ("exampleUsername".equals(username) && "examplePassword".equals(password)) {
            // Authentication successful
            return ResponseEntity.ok().build();
        } else {
            // Authentication failed
            return ResponseEntity.status(401).build(); // 401 Unauthorized status code
        }
    }
	
	

}
