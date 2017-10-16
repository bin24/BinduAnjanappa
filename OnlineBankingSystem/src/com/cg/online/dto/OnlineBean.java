package com.cg.online.dto;

import java.util.Date;

public class OnlineBean {

	private int transactionId;
	private String transactionDescription;
	private Date DateOfTransaction;
	private String transactionType;
	private int transactionamount;
	private int accountNumber;
	
	public OnlineBean()
	{
		
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public Date getDateOfTransaction() {
		return DateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		DateOfTransaction = dateOfTransaction;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(int transactionamount) {
		this.transactionamount = transactionamount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public OnlineBean(int transactionId, String transactionDescription,
			Date dateOfTransaction, String transactionType,
			int transactionamount) {
		super();
		this.transactionId = transactionId;
		this.transactionDescription = transactionDescription;
		DateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.transactionamount = transactionamount;
		
	}

	@Override
	public String toString() {
		return "OnlineBean [transactionId=" + transactionId
				+ ", transactionDescription=" + transactionDescription
				+ ", DateOfTransaction=" + DateOfTransaction
				+ ", transactionType=" + transactionType
				+ ", transactionamount=" + transactionamount
				+ ", accountNumber=" + accountNumber + "]";
	}
	
	
}
