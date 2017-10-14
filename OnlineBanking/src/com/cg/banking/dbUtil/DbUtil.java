package com.cg.banking.dbUtil;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DbUtil {
	
	public static Connection getConnection() throws IOException, SQLException
	{
		Connection conn=null;
		Properties prop=readDBInfo();
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		conn=DriverManager.getConnection(url,username,password);
		
		return conn;
		
		
	}

	private static Properties readDBInfo() throws IOException 
	{
		Properties p=new Properties();
		FileReader fr=new FileReader("BankingInfo.properties");
		p.load(fr);
		return p;
	}

}
