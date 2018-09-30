package com.wallet.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.message.ResponseMessage;
import com.wallet.model.Player;
import com.wallet.service.PlayerService;
/**
 * @author Sanghamitra
 * Controller for handling player related services
 * 
 */
@RestController

public class PlayerController {
	
	Logger logger = LoggerFactory.getLogger(PlayerController.class);
	
	@Autowired
	private PlayerService playerSevice;
		
	@RequestMapping(value={"/saveplayer"}, method=RequestMethod.POST)
    public ResponseMessage savePlayer(@RequestParam("firstName") String firstName, 
    		@RequestParam(required = false) String lastName, @RequestParam("code") String code) {
		
		Player player=Player.builder()
				.firstName(firstName)
				.lastName(lastName)
				.code(code)
				.build();
		playerSevice.save(player);
		
		logger.debug("Player saved");
		
		ResponseMessage response = ResponseMessage.builder()
				.value("Name is: "+firstName+" "+lastName+ " and code is: "+code)
				.message("success")
				.build();
		return response;
    }
	
	@RequestMapping(value={"/playerlist"}, method=RequestMethod.GET)
	public List<Player> getPlayerList(){
		logger.debug("Get playerlist");
		return playerSevice.getPlayerList();
	}
	
	
}
