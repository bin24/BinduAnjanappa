package com.cg.banking.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.banking.bean.UserBean;

public interface IBankingDao {
	
	
	public boolean checkLogin(UserBean bean) throws IOException, SQLException;

	
}
