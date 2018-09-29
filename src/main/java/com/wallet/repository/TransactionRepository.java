package com.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.model.Transaction;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	//public void save(Transaction transaction);
	

}
