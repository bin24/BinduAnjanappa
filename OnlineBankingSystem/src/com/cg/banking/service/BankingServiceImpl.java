package com.cg.banking.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.banking.bean.UserBean;
import com.cg.banking.dao.BankingDaoImpl;
import com.cg.banking.dao.IBankingDao;

public class BankingServiceImpl implements IBankingService {

	IBankingDao dao=new BankingDaoImpl();
	@Override
	public ArrayList<UserBean> getAddr(int accNo) {
		return dao.getAddr(accNo);
	}
	@Override
	public int changeAddr(UserBean bean) {
		return dao.changeAddr(bean);

	}
	@Override
	public int changeMob(UserBean bean) {
		return dao.changeMob(bean);

	}
	@Override
	public boolean validatePhoneNo(String mob){
		String phonepattern="[7-9][0-9]{9}";
		if(Pattern.matches(phonepattern, mob))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter the valid Mobile number");
			return false;
		}
	}
	@Override
	public boolean validateAddress(String address) {
		String ptn="[a-zA-Z]{2,}";
		if(Pattern.matches(ptn, address))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter the valid Address");
			return false;
		}
	}
	@Override
	public boolean checkAccId(int accNo) {
			int res=dao.checkAccId(accNo);
			if(res==1)
			{
				return true;
			}
			else
			{
				return false;
			}
	}
}
