package com.xworkz.jdbcconnectivity.batchprocessing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.jdbcconnectivity.insertstatement.Hotels;

public class BatchProcessing {

	public static void main(String[] args) {

		ArrayList<Hotels> hotels = new ArrayList<Hotels>();
		hotels.add(new Hotels(21, "Hut", 15, 3, true));
		hotels.add(new Hotels(22, "The Square", 0, 4, false));
		hotels.add(new Hotels(23, "Evergreen", 0, 5, false));

		String insertQuery = "insert into Hotels values(?, ?, ?, ?, ?)";

		Connectivity connectivity = new Connectivity();
		try (Connection conn = connectivity.getConnection();
				PreparedStatement prepstmt = conn.prepareStatement(insertQuery);) {

			for (Hotels hotel : hotels) {
				prepstmt.setInt(1, hotel.getId());
				prepstmt.setString(2, hotel.getHotelname());
				prepstmt.setInt(3, hotel.getNoOfRooms());
				prepstmt.setDouble(4, hotel.getRating());
				prepstmt.setBoolean(5, hotel.isRestautant());

				prepstmt.addBatch();
			}
			prepstmt.addBatch("update hotels set hotelName = 'The Friends Fast Food' where idHotels=5");

			int[] results = prepstmt.executeBatch();

			for (int i : results) {
				System.out.println(i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
