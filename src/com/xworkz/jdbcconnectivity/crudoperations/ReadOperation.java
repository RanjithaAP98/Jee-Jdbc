package com.xworkz.jdbcconnectivity.crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadOperation {
	
	public static void main(String[] args) {
		
		String sqlQuery = "select * from salesman";
		
		 try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderdatabase",
															"root", "root"); 
				Statement stmt = conn.createStatement(); 
				ResultSet results = stmt.executeQuery(sqlQuery); 
				){
			    System.out.println(conn);
			
			  System.out.println("Salesman details are :");
			  
			while(results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String city = results.getString(3);
				String commission = results.getString(4);
				
				
				System.out.print("id: " + id );
				System.out.print(" name: "+ name);
				System.out.print(" city: "+ city);
				System.out.print(" : "+commission);
				
			}
		}  
		catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
