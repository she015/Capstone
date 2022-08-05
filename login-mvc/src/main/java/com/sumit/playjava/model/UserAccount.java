package com.sumit.playjava.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
//@Table(name="user_account")
public class UserAccount {

		@Id
		@GenericGenerator(name = "accountno", strategy = "com.sumit.playjava.model.AccountIdGenerator")
	    @GeneratedValue(generator = "accountno") 
	    @Column(columnDefinition = "varchar(22)")
	    private String accountno;
		private String username;
	    private String contactno;
	    private int totalbal;
	    @CreationTimestamp
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date createdate;
	    
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			  this.username = username;
		}
		public String getAccountno() {
			return accountno;
		}
		public void setAccountno(String accountno) {
			this.accountno = accountno;
		}
		public String getContactno() {
			return contactno;
		}
		public void setContactno(String contactno) {
			this.contactno = contactno;
		}
		public int getTotalbal() {
			return totalbal;
		}
		public void setTotalbal(int totalbal) {
			this.totalbal = totalbal;
		}
		public Date getCreatedate() {
			return createdate;
		}
		public void setCreatedate(Date createdate) {
			this.createdate = createdate;
		}
		public UserAccount() {
		
		}
		public UserAccount(String accountno, String username, String contactno, int totalbal, Date createdate) {
			this.accountno = accountno;
			this.username = username;
			this.contactno = contactno;
			this.totalbal = totalbal;
			this.createdate = createdate;
		}
		@Override
		public String toString() {
			return "UserAccount [accountno=" + accountno +" ,username=" + username + ",contactno=" + contactno + ", totalbal=" + totalbal
					+ ", createdate=" + createdate + "]";
		}	
}