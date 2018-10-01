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
import com.wallet.service.AccountService;
import com.wallet.service.TransactionService;

/**
 * @author sanghamitra
 * Controller for handling player related services.
 * This expects an id whic is ext_transaction_id and enum type(credit or debit) in the path variable which is then validated. 
 * transaction_id is a constant and validated
 *
 */
@RestController
public class TransactionController {
	
	public  static final Integer TRANSACTION_ID = 9212;

	@Autowired
	AccountService accountSevice;
	
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
		
		response = transactionService.saveTransaction(type, playerCode, amount, response);
		return response;
	}
	
}
