package com.cg.online.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.online.dto.OnlineBean;

public interface IOnlineService {

	ArrayList<OnlineBean> retriveDetails() throws SQLException, IOException;

}
