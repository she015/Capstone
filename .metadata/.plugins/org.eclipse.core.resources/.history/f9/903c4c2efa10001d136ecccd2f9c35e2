package com.javier.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserAccountService {
	
	@Autowired
	UserAccountRepo userAccountRepo;
	
	public UserAccount updateUserAccount(UserAccount userAccount) {
		UserAccount existingUser= userAccountRepo.findByAccountno(userAccount.getAccountno());
		existingUser.setTotalbal(userAccount.getTotalbal());
	
		
		return userAccountRepo.save(existingUser);
	}
	
	public void save(UserAccount userAccount) {
		userAccountRepo.save(userAccount);
	}
	public List<UserAccount> listAll() {
        return (List<UserAccount>) userAccountRepo.findAll();
    }
     
 /* public UserAccount get(int id) {
        return userAccountRepo.findById(id).get();
    }
     
    public void delete(int id) {
        userAccountRepo.deleteById(id);
    }*/
    
	/*public UserAccount updateUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}