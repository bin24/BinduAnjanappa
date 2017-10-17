package com.cg.banking.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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



	@Override
	public ArrayList<UserBean> changePassword(UserBean bean) throws IOException, SQLException {
		dao=new BankingDaoImpl();
		
		return dao.changePassword(bean);
	}



	@Override
	public boolean checkSecurityAnswer(String securityQuestion,
			String securityAnswer, String sAnswer) {
		
		if(securityAnswer.equals(sAnswer))
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
		
	}



	@Override
	public int updatePassword(UserBean bean) throws SQLException, IOException {
		dao=new BankingDaoImpl();
		
		return dao.updatePassword(bean);
	}



	@Override
	public boolean checkPassword(String newPassword, String reEnterNewPassword) {
		
		if(newPassword.equals(reEnterNewPassword))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}



	



	

	

}
