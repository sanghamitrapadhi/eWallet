package com.wallet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.constant.TransactionType;
import com.wallet.message.ResponseMessage;
import com.wallet.model.Account;
import com.wallet.model.Player;
import com.wallet.model.Transaction;
import com.wallet.service.AccountService;
import com.wallet.service.PlayerService;
import com.wallet.service.TransactionService;

/**
 * @author sanghamitra
 * This service expects a transaction_id and type(credit or debit) in the path variable which is then validated. 
 * transaction_id is a constant and validated
 *
 */
@RestController
public class TransactionController {
	
	public  static final Integer TRANSACTION_ID = 9212;

	@Autowired
	AccountService accountSevice;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private TransactionService transactionService;
	
	Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@RequestMapping(value={"/registertransaction/{id}/"}, method=RequestMethod.POST)
    public ResponseMessage registerTransaction(@PathVariable("id") Integer id, @RequestParam("type") TransactionType type,
			@RequestParam("playerCode") String playerCode, @RequestParam("balance") Double amount) {

		ResponseMessage response = ResponseMessage.builder()
				.value(id.toString())
				.build();

		if (!TRANSACTION_ID.equals(id)) {
			response.setMessage("Please enter correct transaction id");
			logger.debug("Invalid transaction id");
			return response;
		}

		Player player = playerService.findByCode(playerCode);
		Double balance = accountSevice.getBalance(player);
		Double newBalance=0.0;
		
		newBalance = findNewBalance(type, amount, balance);
		
		if (type.equals(TransactionType.DEBIT) && newBalance <= 0) {
			response.setMessage("Insufficient balance");
			logger.debug("Insufficient balance");
			return response;
		} else {
			saveTransaction(type, response, player, newBalance);
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

	private void saveTransaction(TransactionType type, ResponseMessage response, Player player,
			Double newBalance) {
		
		Account account=accountSevice.findByPlayer(player);
		account.setBalance(newBalance);
		accountSevice.save(account);
		
		Transaction transaction = Transaction.builder()
				.account(account)
				.type(type)
				.build();
		
		transactionService.save(transaction);
		
		logger.debug("Transaction saved");
		response.setMessage("Transaction registered successfully");
	}
	
	
}
