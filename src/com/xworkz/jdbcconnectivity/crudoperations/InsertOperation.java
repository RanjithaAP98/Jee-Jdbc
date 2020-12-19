package com.xworkz.jdbcconnectivity.crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InsertOperation {
	
	public static void main(String[] args) {

		ArrayList<Salesman> salesman = new ArrayList<Salesman>();

		salesman.add(new Salesman(3000, "kumar", "mysor", "15%"));
		salesman.add(new Salesman(4000, "smith", "delhi", "30%"));

		for (Salesman sales : salesman) {
			insertRow(sales);
		}
	}

	private static void insertRow(Salesman sales) {
		int id = sales.getId();
		String name = sales.getName();
		String city = sales.getCity();
		String commission = sales.getCommission();

		String sqlQuery = "insert into salesman values(" + id + ", '" + name + "', '" + city + "',' " + commission + "')";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderdatabase", "root", "root");
				Statement stmt = conn.createStatement();) {

			int result = stmt.executeUpdate(sqlQuery);
			System.out.println("The no of rows insert is : " + result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
