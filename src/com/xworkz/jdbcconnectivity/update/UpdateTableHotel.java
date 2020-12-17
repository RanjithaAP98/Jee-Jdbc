package com.xworkz.jdbcconnectivity.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTableHotel {
	
	public static void main(String[] args) {
		
		String sqlQuery = "update hotels set noOfRooms = 60 where idHotels=1";
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldatabase",
													"root", "root"); 
			Statement stmt = conn.createStatement();
			){
			
			int result = stmt.executeUpdate(sqlQuery);  //Updating rows
			System.out.println("The no of rows updated is : "+ result);	
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
