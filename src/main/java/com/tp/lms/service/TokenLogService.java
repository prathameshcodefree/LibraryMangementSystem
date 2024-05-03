package com.tp.lms.service;

import java.time.LocalDateTime;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tp.lms.model.TokenLog;
import com.tp.lms.model.enums.LinkType;
import com.tp.lms.model.enums.Purpose;
import com.tp.lms.repository.TokenLogRepository;

@Service
public class TokenLogService {

	@Autowired
	TokenLogRepository tokenLogRepository;

	public String generateToken(int adminid,String email) {
		String token = UUID.randomUUID().toString();

		LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(1);

		TokenLog tokenLog = new TokenLog();
		tokenLog.setToken(token);
		tokenLog.setValid(true);
		tokenLog.setExpiryTime(expiryTime);
		tokenLogRepository.save(tokenLog);
		return token;
	}

	public boolean verifyToken(String token) {

		Optional<TokenLog> tokenLog = tokenLogRepository.findByToken(token);

		if (tokenLog.isPresent()) {
			TokenLog log = tokenLog.get();
			return log.isValid();
		}

		return false;
	}
	

	public boolean verifyToken1(String token) {
		// Retrieve the token log
		System.out.println("Header 5");
		Optional<TokenLog> tokenLogOptional = tokenLogRepository.findFirstByToken(token);
		if (tokenLogOptional.isPresent()) {
			TokenLog log = tokenLogOptional.get();
			if(log.isValid()) {
				
				LocalDateTime expiryTime=log.getExpiryTime();
				return expiryTime !=null && !expiryTime.isBefore(LocalDateTime.now());
				
			}
			
		}
		

		return false;
	}

	public boolean isTokenExpired(String token) {

		TokenLog tokenLog = tokenLogRepository.findByToken(token).orElse(null);

		if (tokenLog != null && tokenLog.getExpiryTime() != null) {
			LocalDateTime currentTime = LocalDateTime.now();
			return tokenLog.getExpiryTime().isBefore(currentTime);
		}

		return true;
	}



	

	public void invalidateToken(String token) {
		Optional<TokenLog> tokenLogOptional = tokenLogRepository.findByToken(token);
		if (tokenLogOptional.isPresent()) {
			TokenLog tokenLog = tokenLogOptional.get();
			tokenLog.setValid(false); // Mark the token as invalid
			tokenLogRepository.save(tokenLog); // Save the changes to the database
		}
		// You may consider throwing an exception or logging a message if the token is
		// not found
	}



	/*
	 * public String generateToken(int studentId, String email) { String token =
	 * UUID.randomUUID().toString();
	 * 
	 * LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(1);
	 * 
	 * TokenLog tokenLog = new TokenLog(); tokenLog.setToken(token);
	 * tokenLog.setValid(true); tokenLog.setExpiryTime(expiryTime);
	 * 
	 * addLogForStudentLogin(token, studentId, email, expiryTime);
	 * 
	 * return token; }
	 */

	

	public List<TokenLog> getTokenLog() {

		return (List<TokenLog>) tokenLogRepository.findAll();

	}

	public Optional<TokenLog> getTokenLogById(Integer id) {
		return tokenLogRepository.findById(id);

	}


	
	public List<String> validate(TokenLog tokenLog) {

		List<String> error = new ArrayList<>();

		if (tokenLog.getUserName() == null) {
			error.add("TokenLog Username can not be empty");
		}

		if (tokenLog.getToken() == null) {
			error.add("Token can not be empty");
		}

		if (tokenLog.getPurpose() == null) {
			error.add("Purpose can not be empty");
		}

		if (tokenLog.getLinkType() == null) {
			error.add("LinkType can not be empty");
		}
		if (tokenLog.getIp() == null) {
			error.add("IP can not be empty");
		}

		if (tokenLog.getLinkId() == 0) {
			error.add("LinkId can not be empty");
		}

		if (tokenLog.getAttempt() == 0) {
			error.add("Attempt can not be empty");
		}

		return error;
	}

	public TokenLog addLogForStudentLogin(String token, int studentId, String email, LocalDateTime expiryTime) {
		TokenLog tl = new TokenLog();
		tl.setLinkId(studentId);
		tl.setLinkType(LinkType.STUDENT);
		tl.setToken(token);
		tl.setValid(true);
		tl.setPurpose(Purpose.LOGIN);
		tl.setUserName(email);
		tl.setExpiryTime(expiryTime); // Set expiry time
        return tokenLogRepository.save(tl);
    }

	public TokenLog addLogForAdminLogin1(String token,String email,int adminid,LocalDateTime expiryTime) {
		
		
	  TokenLog ts=new TokenLog();
	  ts.setLinkId(adminid);
	  ts.setLinkType(LinkType.ADMIN);
	  ts.setPurpose(Purpose.LOGIN);
	  ts.setValid(true);
	  ts.setUserName(email);
	  ts.setToken(token);
	  ts.setExpiryTime(expiryTime);
	
	  return tokenLogRepository.save(ts);
	  
	  
	}
	
	public TokenLog addLogForAdminLogin(String token,String email,int adminid) {
		

		System.out.println("addLogForAdminLogin 1");
		  TokenLog ts=new TokenLog();
		  ts.setLinkId(adminid);
		  ts.setLinkType(LinkType.ADMIN);
		  ts.setPurpose(Purpose.LOGIN);
		  ts.setValid(true);
		  ts.setUserName(email);
		  ts.setToken(token);

			System.out.println("addLogForAdminLogin 2");
		  return tokenLogRepository.save(ts);
		  
		  
		}

	public TokenLog updateTokenLog(Integer id, TokenLog tokenLog) {
		TokenLog existingStaff = tokenLogRepository.findById(id).orElse(null);
		existingStaff.setUserName(tokenLog.getUserName());
		existingStaff.setToken(tokenLog.getToken());
		existingStaff.setPurpose(tokenLog.getPurpose());
		existingStaff.setLinkType(tokenLog.getLinkType());
		existingStaff.setIp(tokenLog.getIp());
		existingStaff.setLinkId(tokenLog.getLinkId());
		existingStaff.setAttempt(tokenLog.getAttempt());
		return tokenLogRepository.save(existingStaff);
	}

	public boolean deleteTokenLog(Integer id) {

	
		boolean exists = tokenLogRepository.existsById(id);
		if (exists) {
			tokenLogRepository.deleteById(id);
			return true;
		} else {

			return false;
		}

	}

	public boolean inValidateToken(String token) {
	
				Optional<TokenLog> tokenLogOptional = tokenLogRepository.findFirstByToken(token);

				if (tokenLogOptional.isPresent()) {
					TokenLog log = tokenLogOptional.get();
					 log.setValid(false);
					 log.setSetLogoutTime(LocalDateTime.now());
					 log.setExpiryTime(LocalDateTime.now().plusMinutes(1));
					 tokenLogRepository.save(log);
					return true;
				}
		return false;
		
	}

	public boolean validateToken(String token) {
		Optional<TokenLog> token1 =tokenLogRepository.findByToken(token);
		
		
		if(token1.isPresent()) {
			
			TokenLog log=token1.get();
			
			return log.isValid();
		}
		return false;
				
	}

	
}
