package com.simplilearn.jdbc_demo_app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployee {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		
		try {
			// 1. create connection
			 conn = DatabaseConnection.initConnection();
			// 2. create a statement
			 stm = conn.createStatement();
			// 3. create insert query 
			 String query = "insert into employees "+
			"(first_name,last_name,email,department,salary) "+
			"values "+
			"('Miller','David', 'david.miller@gmail.com','Engineering', 29009.00),"+
			"('Ravi','Mahesh', 'ravi.mahesh@gmail.com','Operations', 889009.00)";
			 
			//4 . execute query : insert a new employee
			 int rowsAffected = stm.executeUpdate(query);
			 
			 System.out.println("No of Rows Affected "+rowsAffected);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(stm != null) {
				stm.close();
			}
			
		}

	}

}
