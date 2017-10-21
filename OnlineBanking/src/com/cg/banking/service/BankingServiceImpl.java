package com.cg.banking.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.banking.bean.UserBean;
import com.cg.banking.dao.BankingDaoImpl;
import com.cg.banking.dao.IBankingDao;

public class BankingServiceImpl implements IBankingService {

	IBankingDao imd =null;
	
	public int requestforcheckbook(UserBean u) throws SQLException, IOException {
		
		imd = new BankingDaoImpl();
		return imd.requestforcheckbook(u);
	}

	@Override
	public int addDetails(UserBean u) {
		imd = new BankingDaoImpl();
		return imd.addDetails(u);
	}

	
}
