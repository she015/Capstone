package com.sumit.playjava.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sumit.playjava.model.UserAccount;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, String>{

	UserAccount findByAccountno(String accountno);

   /* public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);*/
}