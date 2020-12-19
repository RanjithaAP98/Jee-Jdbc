package com.xworkz.jdbcconnectivity.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStmtExample {

		public static void main(String[] args) {
			
			String sqlQuery = "insert into hotels values(?, ?, ?, ?, ?)";   // ? ->placeholder for values
			
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldatabase",
																"root", "root"); 
					PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
				){
				int hotelId = 3;
				prepStmt.setInt(1, hotelId);
				prepStmt.setString(2, "Mayyas");
				prepStmt.setBoolean(5, true);
				prepStmt.setInt(3, 0);
				prepStmt.setDouble(4, 4);
				
				boolean issuccessfull = prepStmt.execute(); //CRUD
				//true - ResultSet
				//false - CUD
				System.out.println("was the query execution sucessfull: "+issuccessfull );
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
