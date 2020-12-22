package com.xworkz.jdbcconnectivity.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.jdbcconnectivity.batchprocessing.Connectivity;
import com.xworkz.jdbcconnectivity.insertstatement.Hotels; 

public class TransactionExample {
	
public static void main(String[] args) {
		
		Connectivity connectivity =new Connectivity();
		
		Connection conn=null;
		PreparedStatement prepStmt=null;

		ArrayList<Hotels> hotels = new ArrayList<Hotels>();

		hotels.add(new Hotels(19, "Golden Paradise", 60, 5, true ));
		hotels.add(new Hotels(20, "Heritage", 45, 3, false));
		
		String insertIntoHotel = "insert into hotels values(?,?,?, ?, ?)";
		
		try {
			conn = connectivity.getConnection();
			prepStmt = conn.prepareStatement(insertIntoHotel);
			
			conn.setAutoCommit(false);
			
			for(Hotels hotel : hotels) {  
				prepStmt.setInt(1, hotel.getId());
				prepStmt.setString(2, hotel.getHotelname());
				prepStmt.setInt(3, hotel.getNoOfRooms());
				prepStmt.setDouble(4, hotel.getRating());
				prepStmt.setBoolean(5, hotel.isRestautant());
				
				boolean result = prepStmt.execute();
				System.out.println("Result: "+result);
				
				}	
			
			conn.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			System.out.println("rolled back");
		}

	}
}
