package com.cg.banking.dao;

import java.util.ArrayList;

import com.cg.banking.bean.UserBean;

public interface IBankingDao {

	ArrayList<UserBean> getAddr(int accNo);

	int changeAddr(UserBean bean);

	int changeMob(UserBean bean);

	int checkAccId(int accNo);

}
