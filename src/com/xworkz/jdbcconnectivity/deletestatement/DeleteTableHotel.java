package com.xworkz.jdbcconnectivity.deletestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTableHotel {
	
	public static void main(String[] args) {
		
		String sqlQuery = "delete from hotels where idHotels=3";
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldatabase",
													"root", "root"); 
			Statement stmt = conn.createStatement();
			){
			
			int result = stmt.executeUpdate(sqlQuery);  //Deleting rows
			System.out.println("The no of rows deleted is : "+ result);	
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
