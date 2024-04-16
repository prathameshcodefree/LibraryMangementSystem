package com.tp.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.response.Login;
import com.tp.lms.response.Sucess;
import com.tp.lms.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/add")
    public ResponseEntity<?> addLogin(@RequestBody Login login) {
        List<String> errors = loginService.validate(login);
        if (!errors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new com.tp.lms.response.Error(false, errors.toString()));
        }
        loginService.addLogin(login);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Sucess(true, "Login added successfully"));
    }
    
    
    @PostMapping("/check")
    public ResponseEntity<Object> checkUser(@RequestBody Login login) {
        boolean userExists = loginService.checkUserExists(login.getUsername(), login.getPassword());
        if (userExists) {
            return ResponseEntity.ok(new Sucess(true, "User exists. Login successful."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new com.tp.lms.response.Error(false, "User does not exist."));
        }
    }
}
