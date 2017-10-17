package com.cg.banking.bean;


import java.sql.Date;
import java.time.LocalDate;

public class UserBean {
	private int accid;
	private String name;
	private int acctype;
	private int accbal;
	private Date date;
	private String address;
	private String mobileno;
	private String email;
	public UserBean(int accid, String name, int acctype, int accbal,
			Date date, String address, String mobileno, String email) {
		super();
		this.accid = accid;
		this.name = name;
		this.acctype = acctype;
		this.accbal = accbal;
		this.date = date;
		this.address = address;
		this.mobileno = mobileno;
		this.email = email;
	}
	public UserBean(String name, int acctype, int accbal, Date date,
			String address, String mobileno, String email) {
		super();
		this.name = name;
		this.acctype = acctype;
		this.accbal = accbal;
		this.date = date;
		this.address = address;
		this.mobileno = mobileno;
		this.email = email;
	}
	public UserBean() {
		
	}
	public int getAccid() {
		return accid;
	}
	public void setAccid(int accid) {
		this.accid = accid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAcctype() {
		return acctype;
	}
	public void setAcctype(int acctype) {
		this.acctype = acctype;
	}
	public int getAccbal() {
		return accbal;
	}
	public void setAccbal(int accbal) {
		this.accbal = accbal;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserBean [accid=" + accid + ", name=" + name + ", acctype="
				+ acctype + ", accbal=" + accbal + ", date=" + date
				+ ", address=" + address + ", mobileno=" + mobileno
				+ ", email=" + email + "]";
	}
	


	
}