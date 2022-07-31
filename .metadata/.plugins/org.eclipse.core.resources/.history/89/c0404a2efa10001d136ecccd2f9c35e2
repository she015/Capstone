package com.javier.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	private int accountno;
	private int toaccountnumber;
	private int transferamount;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactiondate;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public int getToaccountnumber() {
		return toaccountnumber;
	}
	public void setToaccountnumber(int toaccountnumber) {
		this.toaccountnumber = toaccountnumber;
	}
	public int getTransferamount() {
		return transferamount;
	}
	public void setTransferamount(int transferamount) {
		this.transferamount = transferamount;
	}
	public Date getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}
	public Transaction() {
	
	}
	public Transaction(int transactionId, int accountno, int toaccountnumber, int transferamount,
			Date transactiondate) {
		super();
		this.transactionId = transactionId;
		this.accountno = accountno;
		this.toaccountnumber = toaccountnumber;
		this.transferamount = transferamount;
		this.transactiondate = transactiondate;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountno=" + accountno + ", toaccountnumber="
				+ toaccountnumber + ", transferamount=" + transferamount + ", transactiondate=" + transactiondate + "]";
	}
	
	
	
}
