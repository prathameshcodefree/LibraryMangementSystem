package com.tp.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.lms.model.TokenLog;
import com.tp.lms.repository.TokenLogRepository;

@Service
public class TokenLogService {

	@Autowired
	private TokenLogRepository tokenLogRepository;

	public List<TokenLog> GetAllToken() {
		return tokenLogRepository.findAll();
	}

	public TokenLog GetTokenLog(int id) {
		return tokenLogRepository.findById(id).get();
	}

	public TokenLog AddTokenLog(TokenLog tokenLog) {
		return tokenLogRepository.save(tokenLog);
	}

	public void DeleteTokenLog(int id) {
		tokenLogRepository.deleteById(id);
	}

	public TokenLog UpdateLogToken(TokenLog tokenLog, int id) {
		tokenLog.setId(id);
		return tokenLogRepository.save(tokenLog);
	}
}
