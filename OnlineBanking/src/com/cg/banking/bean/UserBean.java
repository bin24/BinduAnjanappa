package com.cg.banking.bean;

public class UserBean {
	
	//private String ServiceId;
	private String Service_Desc;
	private int AccountNo;
	public String getService_Desc() {
		return Service_Desc;
	}
	public void setService_Desc(String service_Desc) {
		Service_Desc = service_Desc;
	}
	public int getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	}
	public UserBean(String service_Desc, int accountNo) {
		super();
		Service_Desc = service_Desc;
		AccountNo = accountNo;
	}
	public UserBean() {
		super();
	}
	
	
	

	

}
