package com.cg.banking.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import com.cg.banking.bean.UserBean;
import com.cg.banking.service.BankingServiceImpl;
import com.cg.banking.service.IBankingService;



public class BankingUi {
	public static void main(String[] args) throws IOException, SQLException, ParseException {
		BankingUi o = new BankingUi();
		o.getOperations();
	}
	Scanner sc = new Scanner(System.in);
	private void getOperations() throws IOException, SQLException, ParseException {
		// TODO Auto-generated method stub
		BankingUi o = new BankingUi();
		while(true){
			System.out.println("\n*****************************\nEnter your Choice");
			System.out.println("\n1.Create New Account\n2.Exit");
			int ch = sc.nextInt();
			switch(ch){
			case 1:
				o.createNewAcc();
				break;
			
			case 2:
				System.exit(0);
			}
	}

}
	private void createNewAcc() throws IOException, SQLException, ParseException {
		// TODO Auto-generated method stub
		
		IBankingService service=new BankingServiceImpl();
		service=new BankingServiceImpl();
		  
		System.out.println("Enter Account Holder Name :");
		String name=sc.nextLine();
		System.out.println("Enter Account Type:1.Savings 2.Current");
		int acctype=sc.nextInt();
		System.out.println("Enter Account Balance:");
		int accbal=sc.nextInt();
		System.out.println("Enter Open Date :");
		String date=sc.next();
		System.out.println("Enter Address:");
		String address=sc.next();
		System.out.println("Enter Mobile Number :");
		String mobileno=sc.next();
		System.out.println("Enter Email :");
		String email=sc.next();
		
		UserBean ub = new UserBean(name,acctype,accbal,date,address,mobileno,email);
		int res=service.createNewAcc(ub);
		System.out.println("inserted");
		
		
		
		
		
		
	}}
