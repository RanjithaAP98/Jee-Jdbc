package com.xworkz.jdbcconnectivity.batchprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Statement;

public class FetchRecords { 
	
	public static void main(String args[]) throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedatabase", "root", "root");
		con.setAutoCommit(false);

		Statement stmt = (Statement)con.createStatement();
		
		//insert
		stmt.addBatch("insert into student values('1ki16is011', 'Vijay', 'Tiptur', '21415', 'f')");
		stmt.addBatch("insert into student values('1ki16is012', 'Vinay', 'Tumkur', '21488', 'm')");
		
		//update
		stmt.addBatch("update student set address = 'Mandya' where usn='1ki16is002'");
		
		//delete
		stmt.addBatch("delete from student where  usn='1ki16is003'");
		stmt.addBatch("delete from student where  usn='1ki16is004'");

		stmt.executeBatch();// executing the batch

		con.commit();
		con.close();
	}

}
