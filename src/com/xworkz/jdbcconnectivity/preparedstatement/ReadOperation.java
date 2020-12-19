package com.xworkz.jdbcconnectivity.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadOperation {
	
	public static void main(String[] args) {

		String sqlQuery = "SELECT * FROM salesman;";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderdatabase", "root", "root");
				PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);) {

			ResultSet results = prepStmt.executeQuery();
			System.out.println("Result: " + results);

			System.out.println("salesman details are :");

			while (results.next()) {

				int id = results.getInt("id");
				String name = results.getString("name");
				String city = results.getString(3);
				String commission = results.getString(4);

				System.out.print(" id: " + id);
				System.out.print(" name: " + name);
				System.out.print(" city: " + city);
				System.out.print(" commission: " + commission);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
