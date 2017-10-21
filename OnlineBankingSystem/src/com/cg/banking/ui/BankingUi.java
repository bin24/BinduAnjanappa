package com.cg.banking.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.banking.bean.UserBean;
import com.cg.banking.service.BankingServiceImpl;
import com.cg.banking.service.IBankingService;


public class BankingUi {
	static Scanner sc=new Scanner(System.in);
	static IBankingService service=new BankingServiceImpl();


	public static void main(String[] args) {
		UserBean bean=new UserBean();
		System.out.println("Enter Account Id");
		int accNo=sc.nextInt();
		bean.setAccNo(accNo);
		
		if(service.checkAccId(accNo))
		{
		
		ArrayList<UserBean>list=service.getAddr(accNo);
		for(UserBean o:list)
		{
			System.out.println("\nYour Current Address is: "+o.getAddress());
			System.out.println("Your Current Mobile No. is: "+o.getMobile());
		}
		
		while(true)
		{
			
		System.out.println("\n1. Change address");
		System.out.println("2. Change mobile no.");
		System.out.println("3. Exit\n");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
				System.out.println("\nEnter New Address:");
				String address=sc.next();
				if(service.validateAddress(address))
				{
				bean.setAddress(address);
				int res=service.changeAddr(bean);
				if(res==1)
				{
					System.out.println("\nYour Updated Address is: "+bean.getAddress());
					
					//System.out.println("Your Current Mobile No. is: "+bean.getMobile());
					ArrayList<UserBean>list1=service.getAddr(accNo);
					for(UserBean o:list1)
					{
						System.out.println("Your Current Mobile No. is: "+o.getMobile());
					}
				}
				}
		break;
		case 2:
				System.out.println("\nEnter new Mobile No:");
				long mob=sc.nextLong();
				String num=String.valueOf(mob);
				
				if(service.validatePhoneNo(num))
				{
				bean.setMobile(mob);
				int result=service.changeMob(bean);
				if(result==1)
				{
					//System.out.println("\nYour Updated Address is: "+bean.getAddress());
					ArrayList<UserBean>list2=service.getAddr(accNo);
					for(UserBean o:list2)
					{
						System.out.println("\nYour Current Address is: "+o.getAddress());
					}
					System.out.println("Your Updated Mobile No. is: "+bean.getMobile());

				}
				}
		break;
		case 3:
				System.exit(0);
		break;
			}
		
		}

		}
		else
		{
			System.out.println("Please enter valid Account Id!!!");
		}
	}

}
