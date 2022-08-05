package com.sumit.playjava.controller;

import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.sumit.playjava.model.Transaction;
import com.sumit.playjava.model.User;
import com.sumit.playjava.model.UserAccount;
import com.sumit.playjava.repo.UserRepo;
import com.sumit.playjava.service.TransactionService;
import com.sumit.playjava.service.UserAccountService;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private TransactionService transactionService;
	
	Transaction trans = new Transaction();
	
	UserAccount userAccount = new UserAccount();
	
	RestTemplate restTemplate = new RestTemplate();
	
	int x;
	String accountNo1;
	String username2;
	
	User u = null;
	User y = null;
	
	@RequestMapping("/")
	public String checkMVC() {
		return "login";
		
	}
	
	@RequestMapping("/login")
	public String loginHomePage(@RequestParam("username") String userName,
			@RequestParam("password") String password, Model model) {
		
		try {
			
			u = userRepo.findByUsername(userName);
			y = userRepo.findByPassword(password);
			username2 = u.getUserName();

		}catch(Exception e) {
			model.addAttribute("error", "User is not valid");
		}
		if(u!=null && y!=null) {
			
			model.addAttribute("userName", userName);
			model.addAttribute("password", password);
			return "useraccount";
		}
		return "login";
	}
	
	@RequestMapping("/register")
	public String registerService() {
		return "register";
	}
	
	@RequestMapping("/set-user")
	public String registerMicroservice(@RequestParam("username") String userName, @RequestParam("password1") String password1, 
			@RequestParam("password2") String password2, Model model) {
		
		System.out.println("Going to microservice from login microservice start!");
		
		if(password1.equals(password2)) {
			restTemplate.getForObject("http://localhost:8083/register-user/"+userName+"/"+password1+"", String.class);
			 model.addAttribute("registerSuccess", "Successfull registered. Kindly login");
		}else {
			model.addAttribute("registrationError", "Passwords are not the same!");
		}
		System.out.println("Register microservice from login microservice end!");
		return "login";
	}
	
	@RequestMapping("/useraccount")
	public ModelAndView home() {
		if(Objects.nonNull(x) && Objects.nonNull(y)) {
			List<UserAccount> listUserAccount = userAccountService.findByUsername(username2);
			   ModelAndView mav = new ModelAndView("useraccount");
			   mav.addObject("listUserAccount", listUserAccount);
			   return mav;
		}else {
			   ModelAndView mav = new ModelAndView("redirect:/");
			   return mav;
		}
	   
	}
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
	    model.put("useraccount", userAccount); 
	    return "new_useraccount";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("useraccount") UserAccount userAccount) {
		userAccount.setUsername(username2);
		userAccount.getUsername();
		userAccountService.save(userAccount);
		accountNo1 = userAccount.getAccountno();
		x = userAccount.getTotalbal();
		return "redirect:/useraccount";
	}
	
		@RequestMapping("/transaction")
		public ModelAndView transaction() {
			if(Objects.nonNull(x) && Objects.nonNull(y)) {
				List<Transaction> listTransaction = transactionService.findByUsername(username2);
			    ModelAndView mav = new ModelAndView("transaction");
			    mav.addObject("listTransaction", listTransaction);
			    return mav;
			}else {
				ModelAndView mav = new ModelAndView("redirect:/");
				   return mav;
			}
		}
		
		@RequestMapping("/new-transaction")
		public String newTransactionForm(Map<String, Object> model) {
			model.put("transaction", trans);
			return "new-transaction";
		}

	
	@RequestMapping("/save-transaction")
	public String goToNewTransactionMicroservice(@RequestParam("toaccountnumber") int toaccountnumber, @RequestParam("transferamount") int transferamount, Model model) {
		
		if(Objects.nonNull(accountNo1)) {
		 restTemplate.getForObject("http://localhost:8082/transfer-money/"+accountNo1+"/"+username2+"/"+toaccountnumber+"/"+transferamount+"", String.class);
			 model.addAttribute("transferSuccess", "Successfully Transferred!");
			 	
			 	userAccount.setAccountno(accountNo1);
			 	int transfer = transferamount;
			 	
			 	if(x > transfer) {
					int bal = x;
					int newbal = bal - transfer;
					userAccount.setTotalbal(newbal);
					HttpHeaders header = new HttpHeaders();
			        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			        
			        HttpEntity<UserAccount> entitys = new HttpEntity<UserAccount>(userAccount, header);
	
			        restTemplate.exchange("http://localhost:8082/update-balance", HttpMethod.PUT, entitys, String.class).getBody();
			         
			         x = newbal;
			 	} 
			 	
		return "redirect:/transaction";
		
		}else {
			return "useraccount";
		}
	}
	
	@RequestMapping("/deposit")
	public String newDepositForm(Map<String, Object> model) {
		model.put("transaction", trans);
		return "deposit";
	}
	@RequestMapping("/save-deposit")
	public String goToNewTransactionMicroservice(@RequestParam("transferamount") int transferamount, Model model) {
		
		if(Objects.nonNull(accountNo1)) {
		 restTemplate.getForObject("http://localhost:8082/deposit-money/"+accountNo1+"/"+username2+"/"+transferamount+"", String.class);
			 model.addAttribute("transferSuccess", "Successfully Transferred!");
			 userAccount.setAccountno(accountNo1);
			 
			 	int transfer = transferamount;
			 	
				int bal = x;
				int newbal = bal + transfer;
				userAccount.setTotalbal(newbal);
				HttpHeaders header = new HttpHeaders();
			    header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			        
			    HttpEntity<UserAccount> entitys = new HttpEntity<UserAccount>(userAccount, header);
	
			    restTemplate.exchange("http://localhost:8082/update-balance", HttpMethod.PUT, entitys, String.class).getBody();
			         
			    	x = newbal;
			    	
		return "redirect:/transaction";
		}else {
			return "useraccount";
		}
	}
}

	
