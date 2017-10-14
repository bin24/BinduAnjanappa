package com.cg.online.UI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.online.dto.OnlineBean;
import com.cg.online.service.IOnlineService;
import com.cg.online.service.OnlineServiceImpl;



public class OnlineUI {

	static Scanner sc=new Scanner(System.in);
	static IOnlineService service=new OnlineServiceImpl();
	public static void main(String[] args) throws SQLException, IOException {
		System.out.println("Online Banking Sytem");
		System.out.println("-------------------");
		while(true)
		{
			System.out.println("1.View Mini/Detailed statement:");
			System.out.println("2.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:viewMiniStatement();
				break;
			case 2:
				System.exit(0);
				break;
			
			}
		}
	}
	private static void viewMiniStatement() throws SQLException, IOException {
		ArrayList<OnlineBean> list=service.retriveDetails();
		for(OnlineBean m:list)
		{
			System.out.println(m.getTransactionId());
			System.out.println(m.getTransactionDescription());
			System.out.println(m.getDateOfTransaction());
			System.out.println(m.getTransactionType());
			System.out.println(m.getTransactionamount());
			System.out.println(m.getAccountNumber());
		}
	}
}
