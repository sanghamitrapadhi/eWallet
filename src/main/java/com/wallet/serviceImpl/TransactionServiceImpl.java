package com.wallet.serviceImpl;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wallet.constant.TransactionType;
import com.wallet.message.ResponseMessage;
import com.wallet.model.Account;
import com.wallet.model.Player;
import com.wallet.model.Transaction;
import com.wallet.repository.TransactionRepository;
import com.wallet.service.AccountService;
import com.wallet.service.PlayerService;
import com.wallet.service.TransactionService;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	Logger logger = LoggerFactory.getLogger(TransactionService.class);
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountService accountSevice;
	
	@Autowired
	private PlayerService playerService;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public ResponseMessage saveTransaction(TransactionType type, String playerCode, Double amount, ResponseMessage response) {

		Player player = playerService.findByCode(playerCode);
		Double balance = accountSevice.getBalance(player);

		Double newBalance = 0.0;

		newBalance = findNewBalance(type, amount, balance);

		if (type.equals(TransactionType.DEBIT) && newBalance <= 0) {
			response.setMessage("Insufficient balance");
			logger.debug("Insufficient balance");
			return response;
		} else {
			saveTransaction(type, response, player, newBalance, amount);
		}
		return response;
	}
	
	private synchronized Double findNewBalance(TransactionType type, Double amount, Double balance) {
		Double newBalance;
		if (type.equals(TransactionType.DEBIT)) {
			newBalance = balance - amount;
		} else {
			newBalance = balance + amount;
		}
		return newBalance;
	}
	
	private ResponseMessage saveTransaction(TransactionType type, ResponseMessage response, Player player,
			Double newBalance, Double amount) {
		
		Account account=accountSevice.findByPlayer(player);
		account.setBalance(newBalance);
		accountSevice.save(account);
		
		Transaction transaction = Transaction.builder()
				.account(account)
				.type(type)
				.uniqueTransactionId(type.toString()+UUID.randomUUID().toString())
				.transactionAmount(amount)
				.build();
		
		save(transaction);
		
		logger.debug("Transaction saved with unique transaction id:: "+transaction.getUniqueTransactionId());
		response.setMessage("Transaction "+transaction.getUniqueTransactionId() +" registered successfully");
		return response;
	}
	
}
