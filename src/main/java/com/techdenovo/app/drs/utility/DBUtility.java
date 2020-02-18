package com.techdenovo.app.drs.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	
	final  String url ="jdbc:mysql://localhost:3306/drsdb";
	final  String userName="root";
	final  String password= "";
	public  Connection createConnection() {
		Connection con = null;			
		try {
			DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
			con = DriverManager.getConnection(url,userName,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
