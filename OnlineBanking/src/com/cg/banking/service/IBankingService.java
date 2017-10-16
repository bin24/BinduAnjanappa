package com.cg.banking.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.banking.bean.UserBean;

public interface IBankingService {

	int createNewAcc(UserBean ub) throws IOException, SQLException;

}
