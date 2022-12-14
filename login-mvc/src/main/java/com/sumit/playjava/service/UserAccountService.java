package com.sumit.playjava.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumit.playjava.model.UserAccount;
import com.sumit.playjava.repo.UserAccountRepo;

@Service
@Transactional
public class UserAccountService {
	
	@Autowired
	UserAccountRepo userAccountRepo;
	
	public void save(UserAccount userAccount) {
		System.out.println(userAccount.getTotalbal());
		userAccountRepo.save(userAccount);
	}
	
	/*
	 * public List<UserAccount> listAll() { return (List<UserAccount>)
	 * userAccountRepo.findAll(); }
	 */
   /* public void delete(int id) {
        userAccountRepo.deleteById(id);
    }*/

	public List<UserAccount> findByUsername(String username) {
		// TODO Auto-generated method stub
		return (List<UserAccount>) userAccountRepo.findByUsername(username);
	}
    
	
}
