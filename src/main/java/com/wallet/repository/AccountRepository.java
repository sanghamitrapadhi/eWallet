package com.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.model.Account;
import com.wallet.model.Player;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	 public Account findByPlayer(Player player);

}
