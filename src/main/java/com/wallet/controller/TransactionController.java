package com.wallet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
	
	@RequestMapping(value={"/registertransaction"}, method=RequestMethod.POST)
    public String registerTransaction(){
		//playerSevice.save(new Player("Adam","Davis"));
		//playerSevice.save(new Player("Mark","Lee"));
        return "Player saved";
    }
	
	
}
