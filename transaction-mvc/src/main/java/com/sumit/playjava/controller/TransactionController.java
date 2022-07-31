package com.sumit.playjava.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.playjava.model.*;
import com.sumit.playjava.repo.TransactionRepo;
import com.sumit.playjava.service.UserAccountService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private UserAccountService userAccountService;
	
	Transaction u= new Transaction();
	
	@RequestMapping("/check-transfer")
	public String check() {
		return "checked transfer!";
	}
	
	@PutMapping("/update-balance")
	public UserAccount updateUserAccount(@RequestBody UserAccount user_account) {
		
		return userAccountService.updateUserAccount(user_account);
		
	}
	
	@RequestMapping("/transfer-money/{accountno}/{toaccountnumber}/{transferamount}")
	public String transferMoney(@PathVariable("accountno") int accountno,
			@PathVariable("toaccountnumber") int toaccountnumber, @PathVariable("transferamount") int transferamount) {
		System.out.println("Register microservice from login microservice start!");
				
		
		u.getTransactionId();
		u.setAccountno(accountno);
		u.setToaccountnumber(toaccountnumber);
		u.setTransferamount(transferamount);

		transactionRepo.save(u);
		System.out.println("Transaction microservice from login microservice end!");
		
		return "Successfully Transferred!";
	}
}
