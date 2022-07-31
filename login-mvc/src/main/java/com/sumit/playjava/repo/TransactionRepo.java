package com.sumit.playjava.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sumit.playjava.model.Transaction;
import com.sumit.playjava.model.UserAccount;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

	//Transaction findByAccountNumber(String accountNumber);
	

}
