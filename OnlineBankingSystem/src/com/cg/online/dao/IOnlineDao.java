package com.cg.online.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.online.dto.OnlineBean;

public interface IOnlineDao {

	ArrayList<OnlineBean> retriveDetails() throws SQLException, IOException;

}
