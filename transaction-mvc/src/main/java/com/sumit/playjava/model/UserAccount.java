package com.sumit.playjava.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
//@Table(name="user_account")
public class UserAccount {

    @Id
   /* @GenericGenerator(name = "account_no", strategy = "com.sumit.playjava.model.AccountIdGenerator")
    @GeneratedValue(generator = "account_no") 
    @Column(columnDefinition = "varchar(22)")*/
    private int accountno;
    private String contactno;
    private int totalbal;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
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
	public UserAccount(int accountno, String contactno, int totalbal, Date createdate) {
		this.accountno = accountno;
		this.contactno = contactno;
		this.totalbal = totalbal;
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "UserAccount [accountno=" + accountno + ", contactno=" + contactno + ", totalbal=" + totalbal
				+ ", createdate=" + createdate + "]";
	}	
	
}