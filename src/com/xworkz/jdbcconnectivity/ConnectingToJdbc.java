package com.xworkz.jdbcconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectingToJdbc {

	public static void main(String[] args) {
		
		String sqlQuery = "select * from hotels";
		
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldatabase","root", "root"); 
				Statement stmt = conn.createStatement(); // Environment u can execute ur SQL queries
				ResultSet results = stmt.executeQuery(sqlQuery); //Select stmt
				){
			    System.out.println(conn);
			
			  System.out.println("Hotel details are :");
			  
			while(results.next()) {
				int id = results.getInt("idHotels");
				String name = results.getString("hotelName");
				int noOfRooms = results.getInt(3);
				double rating = results.getDouble(4);
				boolean isRestaurant = results.getBoolean(5);
				
				System.out.print("id: " + id );
				System.out.print(" name: "+ name);
				System.out.print(" noOfRooms: "+ noOfRooms);
				System.out.print(" rating: "+rating);
				System.out.println(" HasRestaurant: "+ isRestaurant);
			}
		} 
		 
		catch (SQLException e) {
			e.printStackTrace();
		} 
//		 finally {		//Optional finally block
//			try {
//				if(conn!=null){
//					rs.close();
//					stmt.close();
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
	}

}
