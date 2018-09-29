package com.wallet.service;

import org.springframework.stereotype.Service;

import com.wallet.model.Account;
import com.wallet.model.Player;

@Service
public interface AccountService {
	
	public void save(Account account);
	
	public Account findByPlayer(Player player);
	
	public Double getBalance(Player player);
	
	

}
