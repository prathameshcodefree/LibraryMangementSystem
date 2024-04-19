package com.tp.lms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tp.lms.model.TokenLog;
import com.tp.lms.model.enums.LinkType;
import com.tp.lms.model.enums.Purpose;
import com.tp.lms.repository.TokenLogRepository;

@Service
public class TokenLogService {

	@Autowired
	TokenLogRepository tokenLogRepository;

	public boolean verifyToken(String token) {

		Optional<TokenLog> tokenLog = tokenLogRepository.findByToken(token);

		if (tokenLog.isPresent()) {
			TokenLog log = tokenLog.get();
			return log.isValid();
		}

		return false;
	}

	/*
	 * public boolean verify(String token) {
	 * 
	 * Optional<TokenLog> tokenLog = tokenLogRepository.findByToken(token); if
	 * (tokenLog.isPresent()) { TokenLog log = tokenLog.get(); log.setValid(false);
	 * return true; } return false;
	 * 
	 * }
	 */

	public void inValidateToken(String token) {
		Optional<TokenLog> tO = tokenLogRepository.findByToken(token);
		if (tO.isPresent()) {
			TokenLog log = tO.get();
			log.setValid(false);
			tokenLogRepository.save(log);

		}
	
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


	public String generateToken() {
		String token = UUID.randomUUID().toString();
		TokenLog tokenLog = new TokenLog();
		tokenLog.setToken(token);
		tokenLog.setValid(true);
		addLogForStudentLogin(token, 0, token);
		return token;

	}

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

	public TokenLog addLogForStudentLogin(String token, int studentId, String email) {

		TokenLog tl = new TokenLog();
		tl.setLinkId(studentId);
		tl.setLinkType(LinkType.STUDENT);
		tl.setToken(token);
		tl.setValid(true);
		tl.setPurpose(Purpose.LOGIN);
		tl.setUserName(email);

		return tokenLogRepository.save(tl);

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

	public String genrateToken() {
		String token = UUID.randomUUID().toString();
		return token;

	}
}
