package com.wallet.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.model.Player;
import com.wallet.repository.PlayerRepository;
import com.wallet.service.PlayerService;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	public List<Player> getPlayerList() {
		return playerRepository.findAll();
		
	}	
	public void save(Player player) {
		playerRepository.save(player);
		
	}
	
	public Player findByCode(String code) {
		return playerRepository.findByCode(code);
	}
}
