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

import com.tp.lms.model.TokenLog;
import com.tp.lms.service.TokenLogService;

@RestController
@RequestMapping("/TokenLog")
public class TokenLogController {

       @Autowired
       private TokenLogService tokenLogService;
       
       @GetMapping
       public List<TokenLog> GetAllTokenLog(){
       return tokenLogService.GetAllToken();
       }
       
       @GetMapping("/{id}")
       public TokenLog GetTokenLog(@PathVariable int id) {
       return tokenLogService.GetTokenLog(id);
       }
       
       @PostMapping
       public TokenLog AddToken(@RequestBody TokenLog tokenLog) {
    	  return tokenLogService.AddTokenLog(tokenLog); 
       }
       
       @PutMapping("/{id}")
       public TokenLog UpdateToken(@RequestBody TokenLog tokenLog,@PathVariable int id) {
    	 return tokenLogService.UpdateLogToken(tokenLog, id);   
       }
       
       @DeleteMapping("/{id}")
       public void DeleteToken(@PathVariable int id) {
        tokenLogService.DeleteTokenLog(id);
       }
}
