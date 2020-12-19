package com.xworkz.jdbcconnectivity.batchprocessing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.jdbcconnectivity.crudoperations.Salesman;

public class BatchProcessing {
	
	public static void main(String[] args) {

		ArrayList<Salesman> salesman = new ArrayList<Salesman>();

		salesman.add(new Salesman(8000, "chethan", "hassan", "50%"));
		salesman.add(new Salesman(9000, "shashi", "mangalore", "10%"));

		String insertQuery = "insert into salesman values(?, ?, ?, ?)";

		Connectivity connectivity = new Connectivity();
		try (Connection conn = connectivity.getConnection();
				PreparedStatement prepstmt = conn.prepareStatement(insertQuery);) {

			for (Salesman sales : salesman) {
				prepstmt.setInt(1, sales.getId());
				prepstmt.setString(2, sales.getName());
				prepstmt.setString(3, sales.getCity());
				prepstmt.setString(4, sales.getCommission());

				prepstmt.addBatch();
			}
			prepstmt.addBatch("update salesman set name = 'faran' where id=6000");

			int[] results = prepstmt.executeBatch();

			for (int i : results) {
				System.out.println(i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
