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
import com.tp.lms.repository.TokenLogRepository;

@Service
public class TokenLogService {

	@Autowired
	TokenLogRepository tokenLogRepository;
	
	private final Map<Integer, String> tokenDB = new HashMap<>();
	
	//private Map<String, Boolean> tokenMap = new HashMap<>();
	
	
	public String storeToken(Integer studentId, String token) {
		 return tokenDB.put(studentId, token);
    }
	
	
	// Verify token
    public boolean verifyToken(Integer studentId, String token) {
        
        if (!tokenDB.containsKey(studentId) || !tokenDB.get(studentId).equals(token)) {
            return false; 
        }

        return true;
    }

	//public boolean validateToken(String token) {
		
	  //  return tokenMap.containsKey(token) && tokenMap.get(token);
	//}

	//public String generateToken() {
	   // String token = UUID.randomUUID().toString();
	    
	   
	  //  tokenMap.put(token, true);
	    
	  //  return token;
	//}
	//public void removeToken(String token) {
   //     tokenMap.remove(token);
   // }
	
	
	/*
	 * public String generateToken() { String token=UUID.randomUUID().toString();
	 * TokenLog tokenLog=new TokenLog(); tokenLog.setToken(token);
	 * tokenLog.setValid(true); addTokenLog(tokenLog); return token;
	 * 
	 * }
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

	public TokenLog addTokenLog(TokenLog tokenLog) {

		return tokenLogRepository.save(tokenLog);

	}

	public TokenLog updateTokenLog(Integer id, @RequestBody TokenLog tokenLog) {
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
}
