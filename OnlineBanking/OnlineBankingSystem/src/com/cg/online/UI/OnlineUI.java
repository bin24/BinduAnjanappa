package com.cg.online.UI;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


import com.cg.online.dto.OnlineBean;
import com.cg.online.service.IOnlineService;
import com.cg.online.service.OnlineServiceImpl;



public class OnlineUI {

	static Scanner sc=new Scanner(System.in);
	static IOnlineService service=new OnlineServiceImpl();
	static OnlineBean bean=new OnlineBean();
	public static void main(String[] args) throws SQLException, IOException, ParseException {
		System.out.println("Online Banking Sytem");
		System.out.println("-------------------");
		while(true)
		{
			System.out.println("1.View Mini/Detailed statement:");
			System.out.println("2.View last 10 teransactions");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:viewMiniStatement();
				break;
			case 2:viewByLast();
				break;
			case 3:
				System.exit(0);
				break;
			
			}
		}
	}
	private static void viewByLast() throws SQLException, IOException {
		System.out.println("Enter the account id");
		int id=sc.nextInt();
		bean.setAccountNumber(id);
		ArrayList<OnlineBean> list=service.retriveLast(id);
		for(OnlineBean m:list)
		{
			System.out.println(m.getTransactionId());
			System.out.println(m.getTransactionDescription());
			System.out.println(m.getDateOfTransaction());
			System.out.println(m.getTransactionType());
			System.out.println(m.getTransactionamount());
			
		}
		
		
	}
	private static void viewMiniStatement() throws SQLException, IOException, ParseException {
		System.out.println("Enter the account id");
		int id=sc.nextInt();
		bean.setAccountNumber(id);
		System.out.println("Enter the starting date");
		String sd=sc.next();
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	     java.util.Date date1 = sdf.parse(sd);
	     sdf.applyPattern("dd-MMM-yyyy");
	     System.out.println(sdf.format(date1));
		
		*/
	
		
	 DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		 
	 LocalDate sdate=LocalDate.parse(sd,formatter);
	
		 
		 System.out.println("Enter the end date");
		 String ed=sc.next();
		 LocalDate edate=LocalDate.parse(ed,formatter);
		 //System.out.println(edate);
			 
		 Date enddate=Date.valueOf(edate);
		 //System.out.println(enddate);
			 

		// LocalDate edate=LocalDate.parse(ed,formatter);
		// Date enddate=Date.valueOf(sdate);
		ArrayList<OnlineBean> list=service.retriveDetails(id,sdate,edate);
		for(OnlineBean m:list)
		{
			System.out.println(m.getTransactionId());
			System.out.println(m.getTransactionDescription());
			System.out.println(m.getDateOfTransaction());
			System.out.println(m.getTransactionType());
			System.out.println(m.getTransactionamount());
			
		}
	}
}
