package com.cg.banking.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.banking.bean.UserBean;

public interface IBankingService {

	
	public boolean checkLogin(UserBean bean) throws IOException, SQLException;


}
