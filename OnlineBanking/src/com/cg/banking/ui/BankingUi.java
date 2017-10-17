package com.cg.banking.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.banking.bean.UserBean;
import com.cg.banking.bean.UserBean1;
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
			System.out.println("******************************************************************");
			System.out.println("********************************BANK******************************");
			System.out.println("******************************************************************");
			System.out.println("Enter Your Choice");
			
			System.out.println("\n1.Create New Account\n2.Retrive Transcations\n3.Exit");
			int ch = sc.nextInt();
			switch(ch){
			case 1:
				o.createNewAcc();
				break;
			case 2:
				o.reteriveTrans();
				break;
			case 3:
				System.exit(0);
			}
	}

}
	private void reteriveTrans() throws IOException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("\n1.Daily Trans\n2.Monthly Trans\n3.Quaterly Trans\n4.Yearly Trans");
		int ch1= sc.nextInt();
		switch(ch1){
		case 1:
			reteriveDaily();
			break;
		case 2:
			reteriveMonthly();
			break;
		case 4:
			reteriveYearly();
			break;
		case 5:
			System.exit(0);
		}
	}
	private void reteriveYearly() throws IOException, SQLException {
		// TODO Auto-generated method stub
		IBankingService service=new BankingServiceImpl();
		ArrayList<UserBean1> al=service.reteriveYearly();
		for(UserBean1 ub1:al){
			System.out.println(ub1);	
		}
		System.out.println("These are the yearly details");
	}
	private void reteriveMonthly() throws IOException, SQLException {
		// TODO Auto-generated method stub
		IBankingService service=new BankingServiceImpl();
		ArrayList<UserBean1> al=service.reteriveMonthly();
		for(UserBean1 ub1:al){
			System.out.println(ub1);	
		}
		System.out.println("These are the  monthly details");
		
	}
	private void reteriveDaily() throws IOException, SQLException {
		IBankingService service=new BankingServiceImpl();
		ArrayList<UserBean1> al=service.reteriveDaily();
		for(UserBean1 ub1:al){
			System.out.println(ub1);	
		}
		System.out.println("These are the  all details");
	}
	private void createNewAcc() throws IOException, SQLException, ParseException {
		// TODO Auto-generated method stub
		
		IBankingService service=new BankingServiceImpl();
		
		  
		System.out.println("Enter Account Holder Name :");
		String name=sc.nextLine();
		System.out.println("Enter Account Type:1.Savings 2.Current");
		int acctype=sc.nextInt();
		System.out.println("Enter Account Balance:");
		int accbal=sc.nextInt();
		System.out.println("Enter Open Date :");
		String date=sc.next();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate odate=LocalDate.parse(date,formatter);
		Date od=Date.valueOf(odate);
		
		System.out.println("Enter Address:");
		String address=sc.next();
		System.out.println("Enter Mobile Number :");
		String mobileno=sc.next();
		System.out.println("Enter Email :");
		String email=sc.next();
		
		UserBean ub = new UserBean(name,acctype,accbal,od,address,mobileno,email);
		int res=service.createNewAcc(ub);
		System.out.println("inserted");
		
		
		
		
		
		
	}}
