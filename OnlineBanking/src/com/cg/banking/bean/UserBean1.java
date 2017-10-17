package com.cg.banking.bean;

import java.util.Date;

public class UserBean1 {
	//Transcations
	private int transactionID; 
	private String trandescription;
	private Date dateofTransaction;
	private String transactionType;
	private int tranAmount; 
	private int accountNo;
	public UserBean1(int transactionID, String trandescription,
			Date dateofTransaction, String transactionType, int tranAmount,
			int accountNo) {
		super();
		this.transactionID = transactionID;
		this.trandescription = trandescription;
		this.dateofTransaction = dateofTransaction;
		this.transactionType = transactionType;
		this.tranAmount = tranAmount;
		this.accountNo = accountNo;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public String getTrandescription() {
		return trandescription;
	}
	public void setTrandescription(String trandescription) {
		this.trandescription = trandescription;
	}
	public Date getDateofTransaction() {
		return dateofTransaction;
	}
	public void setDateofTransaction(Date dateofTransaction) {
		this.dateofTransaction = dateofTransaction;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(int tranAmount) {
		this.tranAmount = tranAmount;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public UserBean1() {
	
	}
	@Override
	public String toString() {
		return "UserBean1 [transactionID=" + transactionID
				+ ", trandescription=" + trandescription
				+ ", dateofTransaction=" + dateofTransaction
				+ ", transactionType=" + transactionType + ", tranAmount="
				+ tranAmount + ", accountNo=" + accountNo + "]";
	}
	
}
