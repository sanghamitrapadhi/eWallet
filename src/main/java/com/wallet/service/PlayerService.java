package com.wallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wallet.model.Player;

@Service
public interface PlayerService {
	
	List<Player> getPlayerList();
	
	public void save(Player player);
	
	public Player findByCode(String code);
	

}
