package com.sumit.playjava.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumit.playjava.model.UserAccount;

public interface UserAccountRepo extends JpaRepository<UserAccount, String>{

	List<UserAccount> findByUsername(String username);

	//UserAccount findByAccountno(int accountno);


	//UserAccount findByAccountNo(int accountno);
	//UserAccount findByTotalBal(int totalBal);
	

   /* public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);*/
}