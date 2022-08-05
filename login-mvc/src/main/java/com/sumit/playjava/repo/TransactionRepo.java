package com.sumit.playjava.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sumit.playjava.model.Transaction;


@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

	List<Transaction> findByUsername(String username);


	//Transaction findByAccountNumber(String accountNumber);
	

}
