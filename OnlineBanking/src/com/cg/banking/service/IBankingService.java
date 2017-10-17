package com.cg.banking.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.banking.bean.UserBean;
import com.cg.banking.bean.UserBean1;

public interface IBankingService {

	int createNewAcc(UserBean ub) throws IOException, SQLException;

	ArrayList<UserBean1> reteriveDaily() throws IOException, SQLException;

	ArrayList<UserBean1> reteriveMonthly() throws IOException, SQLException;

	ArrayList<UserBean1> reteriveYearly() throws IOException, SQLException;

}
