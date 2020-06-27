package com.simplilearn.jdbc_demo_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddEmployeeByPS {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			
			// 1. create connection
			conn = DatabaseConnection.initConnection();
			
			String sql = "insert into employees "+
					"(first_name,last_name,email,department,salary) "+
					"values "+
					"(?,?,?,?,?)";
			
			// 2. prepare statement
			pstm = conn.prepareStatement(sql);
			
			//set parameters
			pstm.setString(1, "Sanjeev");
			pstm.setString(2, "Ashok");
			pstm.setString(3, "sanjeev.ashok@gmail.com");
			pstm.setString(4, "Testing");
			pstm.setDouble(5, 1256895.45);
			
			// 3. execute query
			int rowsAffected = pstm.executeUpdate();
			System.out.println("No of Employee Inserted "+rowsAffected);	
			
			//reusing prepared pstm.
			pstm.setString(1, "G");
			pstm.setString(2, "Ghanti");
			pstm.setString(3, "g.ganthi@gmail.com");
			pstm.setString(4, "Testing");
			pstm.setDouble(5, 9856895.45);
			
			// 3. execute query
			int rowsAffected2 = pstm.executeUpdate();
			System.out.println("No of Employee Inserted "+rowsAffected2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pstm.close();
			conn.close();
		}

	}

}
