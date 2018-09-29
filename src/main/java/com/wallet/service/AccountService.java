package com.wallet.service;

import org.springframework.stereotype.Service;

import com.wallet.model.Account;

@Service
public interface AccountService {
	
	public void save(Account account);
	
	public Account findByPlayerId(Long playerId);
	

}
