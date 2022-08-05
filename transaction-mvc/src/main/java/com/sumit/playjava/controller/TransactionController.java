package com.sumit.playjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.playjava.model.Transaction;
import com.sumit.playjava.model.UserAccount;
import com.sumit.playjava.repo.TransactionRepo;
import com.sumit.playjava.service.UserAccountService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private UserAccountService userAccountService;
	
	
	@RequestMapping("/check-transfer")
	public String check() {
		return "checked transfer!";
	}
	
	@PutMapping("/update-balance")
	public UserAccount updateUserAccount(@RequestBody UserAccount user_account) {
		
		return userAccountService.updateUserAccount(user_account);
		
	}
	
	@RequestMapping("/transfer-money/{accountno}/{username}/{toaccountnumber}/{transferamount}")
	public String transferMoney(@PathVariable("accountno") String accountno, @PathVariable("username") String username, @PathVariable("toaccountnumber") int toaccountnumber, 
			@PathVariable("transferamount") int transferamount) {
		System.out.println("Register microservice from login microservice start!");
				
		Transaction u= new Transaction();
		u.getTransactionId();
		u.setUsername(username);
		u.setAccountno(accountno);
		u.setToaccountnumber(toaccountnumber);
		u.setTransferamount(transferamount);
		
		transactionRepo.save(u);
		System.out.println("Transaction microservice from login microservice end!");
		
		return "Successfully Transferred!";
	}
	
	@RequestMapping("/deposit-money/{accountno}/{username}/{transferamount}")
	public String transferMoney(@PathVariable("accountno") String accountno, @PathVariable("username") String username, @PathVariable("transferamount") int transferamount) {
		System.out.println("Register microservice from login microservice start!");
				
		Transaction u= new Transaction();
		u.getTransactionId();
		u.setUsername(username);
		u.setAccountno(accountno);
		u.setTransferamount(transferamount);
		
		transactionRepo.save(u);
		System.out.println("Transaction microservice from login microservice end!");
		
		return "Successfully Deposited!";
	}
}
