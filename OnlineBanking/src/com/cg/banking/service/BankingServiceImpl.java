package com.cg.banking.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.banking.bean.UserBean;
import com.cg.banking.dao.BankingDaoImpl;
import com.cg.banking.dao.IBankingDao;



public class BankingServiceImpl implements IBankingService {
	
	IBankingDao dao=null;

	

	@Override
	public boolean checkLogin(UserBean bean) throws IOException, SQLException {
		dao=new BankingDaoImpl();
		
		return dao.checkLogin(bean);
	}

	

}
