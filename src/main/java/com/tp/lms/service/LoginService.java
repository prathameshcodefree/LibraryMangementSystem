package com.tp.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.lms.repository.LoginRepository;
import com.tp.lms.response.Login;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public List<String> validate(Login login) {
        List<String> errors = new ArrayList();
        if (login.getUsername() == null || login.getUsername().isEmpty()) {
            errors.add("Username cannot be null or empty");
        }
        if (login.getPassword() == null || login.getPassword().isEmpty()) {
            errors.add("Password cannot be null or empty");
        }
        return errors;
    }

    public void addLogin(Login login) {
        loginRepository.save(login);
    }

    public boolean checkUserExists(String username, String password) {
        List<Login> logins = (List<Login>) loginRepository.findAll();
        
        for (Login login : logins) {
            if (login.getUsername().equals(username) && login.getPassword().equals(password)) {
                return true;
            }
        }
        
        return false;
    }}

