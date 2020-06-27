package com.simplilearn.jdbc_demo_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadEmployeeByPrepareStatement {

	public static void main(String[] args) {
		try {
			// 1. create connection object
			System.out.println("Create Statement");
			Connection conn = DatabaseConnection.initConnection();
			
			// fetch employees where salray is > 80000 and depart engineering
			// 2. Prepare Statement
			PreparedStatement pstm = conn.prepareStatement("select * from employees where salary> ? and department=?");
			
			//3. set parameters
			pstm.setDouble(1, 8000);
			pstm.setString(2, "Engineering");
			
			//4. Execute SQL query
			ResultSet rst = pstm.executeQuery();
			displayRecords(rst);
			
			//re using the prepared query 
			pstm.setDouble(1, 80000);
			pstm.setString(2, "Operations");
			
			//4. Execute SQL query
			ResultSet rst2 = pstm.executeQuery();
			displayRecords(rst2);
			
			
		} catch (Exception e) {
			
		}
		
		

	}
	
	public static void displayRecords(ResultSet rst) throws SQLException {
		while(rst.next()) {
			System.out.println("-----------------------");
			 System.out.println(rst.getString("first_name"));
			 System.out.println(rst.getString("last_name"));
			 System.out.println(rst.getString("email"));
			 System.out.println(rst.getDouble("salary"));
			 System.out.println(rst.getString("department"));
		}
	}

}
