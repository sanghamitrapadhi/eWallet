package com.wallet.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wallet.model.Transaction;
import com.wallet.repository.TransactionRepository;
import com.wallet.service.TransactionService;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
	}


}
