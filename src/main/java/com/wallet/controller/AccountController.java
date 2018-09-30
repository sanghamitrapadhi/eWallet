package com.wallet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.constant.AccountType;
import com.wallet.message.ResponseMessage;
import com.wallet.model.Account;
import com.wallet.model.Player;
import com.wallet.service.AccountService;
import com.wallet.service.PlayerService;
/**
 * @author Sanghamitra
 * Controller for handling account related services
 * 
 */
@RestController
public class AccountController {
	
	Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	AccountService accountSevice;
	
	@Autowired 
	PlayerService playerService;
	
	@RequestMapping(value={"/getbalance/{code}"}, method=RequestMethod.GET)
	public ResponseMessage getBalance(@PathVariable("code") String code){
		
		Player player=playerService.findByCode(code);
		
		Double balance=accountSevice.findByPlayer(player).getBalance();
		logger.debug("Account balance is " +balance);
		
		ResponseMessage response = ResponseMessage.builder()
				.value(balance.toString())
				.message("success")
				.build();
		return response;
	}
	
	@RequestMapping(value={"/createaccount"}, method=RequestMethod.POST)
    public ResponseMessage createAccount( @RequestParam("code") String code){		
		
		Account account=Account.builder()
				.balance(0.0)
				.accountType(AccountType.CURRENT)
				.player(playerService.findByCode(code))		
				.build();		
		
		accountSevice.save(account);
		
		logger.debug("Account created with name "+account.getAccountType() + " and balance is zero");
		
		ResponseMessage response = ResponseMessage.builder()
				.value(account.getAccountType()+" Account")
				.message("Account created successfully ")
				.build();
		return response;
    }
	
	
	
}
