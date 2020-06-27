package com.simplilearn.jdbc_demo_app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadEmployees {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		
		try {
			// 1. create connection
			 conn = DatabaseConnection.initConnection();
			// 2. create a statement
			 stm = conn.createStatement();
			// 3. read query
			 String query = "select * from employees";
			 rst = stm.executeQuery(query);
			 // 4. read result set
			 while(rst.next()) {
				 System.out.println("-----------------------");
				 System.out.println(rst.getString("first_name"));
				 System.out.println(rst.getString("last_name"));
				 System.out.println(rst.getString("email"));
				 System.out.println(rst.getDouble("salary"));
				 System.out.println(rst.getString("department"));
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}

// WO for read one employee  : 
//1 . select * from employees where id='4';
//2. select * from employees where first_name='John' and last_name='Smith';


// 2. write update query with PS for updating an employee with 
// first_name ="G" and last_name ="xyz"  where id="2";

// delete employee with PS where id = 10;





