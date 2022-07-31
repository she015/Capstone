package com.sumit.playjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.playjava.model.User;
import com.sumit.playjava.model.repo.UserRepo;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserRepo userRepo;
	
	@RequestMapping("/check")
	public String check() {
		return "checked";
	}
	
	@RequestMapping("/register-user/{username}/{password}")
	public String registerUser(@PathVariable("username") String userName,
			@PathVariable("password") String password) {

		User u= new User();
		u.setId(1);
		u.setUserName(userName);
		u.setPassword(password);
		
		//reg micro end
		userRepo.save(u);
		return "Successfully registered.";
	}
}
