package com.sumit.playjava.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumit.playjava.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

	//Transaction findByAccountNumber(String accountNumber);

}
