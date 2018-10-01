package com.wallet.service;

import org.springframework.stereotype.Service;

import com.wallet.constant.TransactionType;
import com.wallet.message.ResponseMessage;
import com.wallet.model.Transaction;

@Service
public interface TransactionService {
	
	public void save(Transaction transaction);

	public ResponseMessage saveTransaction(TransactionType type, String playerCode, Double amount, ResponseMessage response);

}
