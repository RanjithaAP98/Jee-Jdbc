package com.xworkz.jdbcconnectivity.crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteOperation {
	
	public static void main(String[] args) {
		
		String sqlQuery = "delete from salesman where id=2000";
		
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderdatabase",
															"root", "root"); 
			Statement stmt = conn.createStatement();
			){
			
			int result = stmt.executeUpdate(sqlQuery);  
			System.out.println("The no of rows deleted is : "+ result);	
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}


}
