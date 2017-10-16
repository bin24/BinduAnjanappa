package com.cg.banking.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.banking.bean.UserBean;
import com.cg.banking.dao.BankingDaoImpl;
import com.cg.banking.dao.IBankingDao;


public class BankingServiceImpl implements IBankingService {

	@Override
	public int createNewAcc(UserBean ub) throws IOException, SQLException {
		IBankingDao ibd = new BankingDaoImpl();
		return ibd.createNewAcc(ub);
	}

}
