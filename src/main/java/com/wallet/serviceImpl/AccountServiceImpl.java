package com.wallet.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wallet.model.Account;
import com.wallet.model.Player;
import com.wallet.repository.AccountRepository;
import com.wallet.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Account account) {
		accountRepository.save(account);	
	}
	
	public Account findByPlayer(Player player) {
		return accountRepository.findByPlayer(player);
	}

	public Double getBalance(Player player){
		return accountRepository.findByPlayer(player).getBalance();
	}

}
