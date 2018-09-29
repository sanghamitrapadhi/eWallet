package com.wallet.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.model.Account;
import com.wallet.repository.AccountRepository;
import com.wallet.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public void save(Account account) {
		accountRepository.save(account);	
	}
	
	public Account findByPlayerId(Long playerId) {
		return accountRepository.findByPlayerId(playerId);
	}


}
