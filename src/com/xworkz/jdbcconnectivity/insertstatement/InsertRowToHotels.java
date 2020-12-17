package com.xworkz.jdbcconnectivity.insertstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InsertRowToHotels {
	
	public static void main(String[] args) {
		
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		
		hotels.add(new Hotel(5, "MTR", 0, 4, true));
		hotels.add(new Hotel(6, "Golden Paradise", 60, 5, true ));
		hotels.add(new Hotel(7, "Heritage", 45, 3, false));

		for(Hotel hotel : hotels ) {
			insertRow(hotel);
		}
	}

	private static void insertRow(Hotel hotel) {
		int id = hotel.getId();
		String hotelname = hotel.getHotelname();
		int noOfRooms = hotel.getNoOfRooms() ;
		double rating = hotel.getRating();
		boolean isRestautant = hotel.isRestautant();
		String sqlQuery = "insert into hotels values("+id+", '"+hotelname+"', "+noOfRooms+", "+rating+" , "+isRestautant+")";
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldatabase",
															"root", "root"); 
			Statement stmt = conn.createStatement();
			){
			
			int result = stmt.executeUpdate(sqlQuery);  //Updating, insert, delete rows
			System.out.println("The no of rows insert is : "+ result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
