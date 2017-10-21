package com.cg.banking.service;

import java.util.ArrayList;

import com.cg.banking.bean.UserBean;

public interface IBankingService {

	ArrayList<UserBean> getAddr(int accNo);

	int changeAddr(UserBean bean);

	int changeMob(UserBean bean);

	boolean validatePhoneNo(String mob);

	boolean validateAddress(String address);

	boolean checkAccId(int accNo);

}
