package com.xworkz.jdbcconnectivity.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.jdbcconnectivity.crudoperations.Salesman;

public class InsertOperation {
	
	public static void main(String[] args) {

		ArrayList<Salesman> salesman = new ArrayList<Salesman>();

		salesman.add(new Salesman(6000, "harsha", "hydrabad", "5%"));
		salesman.add(new Salesman(7000, "vivek", "chennai", "40%"));

		String insertQuery = "insert into salesman values(?, ?, ?, ? )";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderdatabase", "root", "root");
				PreparedStatement prepstmt = conn.prepareStatement(insertQuery);) {

			for (Salesman sales : salesman) {
				prepstmt.setInt(1, sales.getId());
				prepstmt.setString(2, sales.getName());
				prepstmt.setString(3, sales.getCity());
				prepstmt.setString(4, sales.getCommission());

				boolean result = prepstmt.execute();
				System.out.println("Result: " + result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
