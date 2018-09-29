package com.wallet.service;

import org.springframework.stereotype.Service;

import com.wallet.model.Transaction;

@Service
public interface TransactionService {
	
	public void save(Transaction transaction);

}
