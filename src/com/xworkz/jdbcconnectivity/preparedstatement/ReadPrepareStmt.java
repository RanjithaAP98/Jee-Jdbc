package com.xworkz.jdbcconnectivity.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadPrepareStmt {
	
	public static void main(String[] args) {

		String sqlQuery = "SELECT * FROM hotels;";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldatabase", "root", "root");
				PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);) {

			ResultSet results = prepStmt.executeQuery();
			System.out.println("Result: " + results);

			System.out.println("Hotel details are :");

			while (results.next()) {

				int id = results.getInt("idHotels");
				String name = results.getString("hotelName");
				int noOfRooms = results.getInt(3);
				double rating = results.getDouble(4);
				boolean isRestaurant = results.getBoolean(5);

				System.out.print("id: " + id);
				System.out.print(" name: " + name);
				System.out.print(" noOfRooms: " + noOfRooms);
				System.out.print(" rating: " + rating);
				System.out.println(" HasRestaurant: " + isRestaurant);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
