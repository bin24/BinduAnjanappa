package com.cg.banking.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.banking.bean.UserBean;


public interface IBankingDao {
	
	
	public boolean checkLogin(UserBean bean) throws IOException, SQLException;

	public ArrayList<UserBean> changePassword(UserBean bean) throws IOException, SQLException;
	
	public int updatePassword(UserBean bean) throws SQLException, IOException;
	
	public int updateLock(UserBean bean) throws IOException, SQLException;

	public ArrayList<UserBean> getAccountId(UserBean bean) throws IOException, SQLException;
}
