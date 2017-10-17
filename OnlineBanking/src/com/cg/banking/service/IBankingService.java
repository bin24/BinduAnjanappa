package com.cg.banking.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.banking.bean.UserBean;

public interface IBankingService {

	
	public boolean checkLogin(UserBean bean) throws IOException, SQLException;

	public ArrayList<UserBean> changePassword(UserBean bean) throws IOException, SQLException;

	

	

	public boolean checkSecurityAnswer(String securityQuestion,String securityAnswer, String sAnswer);
	
	
	public int updatePassword(UserBean bean) throws SQLException, IOException;

	public boolean checkPassword(String newPassword, String reEnterNewPassword);
}
