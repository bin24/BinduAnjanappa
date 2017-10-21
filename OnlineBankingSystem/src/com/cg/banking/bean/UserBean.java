package com.cg.banking.bean;

public class UserBean {
	private int accNo;
	private String name;
	private String email;
	private String address;
	private String pancard;
	private long mobile;
	

	public int getAccNo() {
		return accNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	
	
	public UserBean(int accNo, String name, String email, String address,
			String pancard, long mobile) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.email = email;
		this.address = address;
		this.pancard = pancard;
		this.mobile = mobile;
	}
	
	public UserBean() {
	}
	
	public UserBean(String address, long mobile) {
		super();
		this.address = address;
		this.mobile = mobile;
	}
	
	
	

}
