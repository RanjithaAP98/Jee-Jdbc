package com.xworkz.jdbcconnectivity.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteOperation {
	
	public static void main(String[] args) {

		String sqlQuery = "delete from salesman where id=3000";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderdatabase", "root", "root");
				PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);) {

			boolean result = prepStmt.execute();
			System.out.println("Result: " + result);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
