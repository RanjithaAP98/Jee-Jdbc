package com.xworkz.jdbcconnectivity.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateOperation {

	public static void main(String[] args) {

		String sqlQuery = "update salesman set name = ? where id = ?";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderdatabase", "root", "root");
				PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);) {
			
			int id = 2000;
			prepStmt.setString(1, "james");
			prepStmt.setInt(2, id);

			boolean result = prepStmt.execute();
			System.out.println("Result: " + result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
