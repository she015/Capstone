package com.sumit.playjava.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sumit.playjava.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByUsername(String userName);
	User findByPassword(String password);
}
