package com.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
	
	 public Player findByCode(String code);

}
