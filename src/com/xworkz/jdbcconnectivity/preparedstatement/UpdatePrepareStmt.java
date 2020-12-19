package com.xworkz.jdbcconnectivity.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePrepareStmt {
	
	public static void main(String[] args) {
		
		String sqlQuery = "update hotels set hotelName = ? where idHotels = ?";
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldatabase",
				            								"root", "root"); 
				PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
			){
			int hotelId = 3;
			prepStmt.setString(1, "Sherlton");
			prepStmt.setInt(2, hotelId);
			
			boolean result = prepStmt.execute();
			System.out.println("Result: "+result);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
