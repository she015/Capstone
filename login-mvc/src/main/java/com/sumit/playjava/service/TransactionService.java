package com.sumit.playjava.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sumit.playjava.model.*;
import com.sumit.playjava.repo.TransactionRepo;

@Service
@Transactional
public class TransactionService {
	
	@Autowired
	TransactionRepo transactionRepo;
	
	
	public List<Transaction> listAll() {
		 return (List<Transaction>) transactionRepo.findAll();
	}


	public List<Transaction> findByUsername(String username) {
		// TODO Auto-generated method stub
		return (List<Transaction>) transactionRepo.findByUsername(username);
	}


	/*@Autowired
	private UserAccountRepo userAccountRepo;
	
	public UserAccount updateUserAccount(UserAccount userAccount) {
		UserAccount existingUser= userAccountRepo.findByAccountno(userAccount.getAccountno());
		existingUser.setTotalbal(userAccount.getTotalbal());
	
		
		return userAccountRepo.save(existingUser);
	}*/



}
