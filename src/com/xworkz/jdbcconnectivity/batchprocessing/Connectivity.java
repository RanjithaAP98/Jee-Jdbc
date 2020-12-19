package com.xworkz.jdbcconnectivity.batchprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectivity {
	
	public Connection getConnection() throws SQLException{
		
		return  DriverManager.getConnection("jdbc:mysql://localhost:3306/orderdatabase", "root", "root");
	}

}
