package com.xworkz.jdbcconnectivity.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.jdbcconnectivity.insertstatement.Hotels;

public class InsertUsingPreparedStmt {
	
	public static void main(String[] args) {
		
		ArrayList<Hotels> hotels = new ArrayList<Hotels>();
		
		hotels.add(new Hotels(12, "Namaste Cafe", 0, 3.5, true));
		hotels.add(new Hotels(13, "Karavalli", 50, 5, true ));
		hotels.add(new Hotels(14, "Sheraton", 40, 3, false));

		String insertQuery = "insert into Hotels values(?, ?, ?, ? ,?)";
		try( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldatabase",
															"root", "root"); 
			PreparedStatement prepstmt = conn.prepareStatement(insertQuery);
				){
			
			for(Hotels hotel : hotels) {  
				prepstmt.setInt(1, hotel.getId());
				prepstmt.setString(2, hotel.getHotelname());
				prepstmt.setInt(3, hotel.getNoOfRooms());
				prepstmt.setDouble(4, hotel.getRating());
				prepstmt.setBoolean(5, hotel.isRestautant());
				
				// 1st //insert into hotels values(12,"Namaste Cafe", 0, 3.5, 1);
				// 2nd //insert into hotels values(13, "Karavalli", 50, 5, 1);
				//3rd //insert into hotels values(14,"Sheraton", 40, 3, 0);
				
				boolean result = prepstmt.execute();
				System.out.println("Result: "+result);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
