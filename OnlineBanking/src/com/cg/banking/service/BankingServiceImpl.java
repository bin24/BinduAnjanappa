package com.cg.banking.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.banking.bean.UserBean;
import com.cg.banking.bean.UserBean1;
import com.cg.banking.dao.BankingDaoImpl;
import com.cg.banking.dao.IBankingDao;


public class BankingServiceImpl implements IBankingService {

	@Override
	public int createNewAcc(UserBean ub) throws IOException, SQLException {
		IBankingDao ibd = new BankingDaoImpl();
		return ibd.createNewAcc(ub);
	}

	@Override
	public ArrayList<UserBean1> reteriveDaily() throws IOException, SQLException {
		// TODO Auto-generated method stub
		IBankingDao ibd = new BankingDaoImpl();
		return ibd.reteriveDaily();
	}

	@Override
	public ArrayList<UserBean1> reteriveMonthly() throws IOException, SQLException {
		// TODO Auto-generated method stub
		IBankingDao ibd = new BankingDaoImpl();
		return ibd.reteriveMonthly();
		
	}

	@Override
	public ArrayList<UserBean1> reteriveYearly() throws IOException, SQLException {
		// TODO Auto-generated method stub
		IBankingDao ibd = new BankingDaoImpl();
		return ibd.reteriveYearly();
		
	}

}
