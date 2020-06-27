package com.simplilearn.jdbc_demo_app;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateEmployeePs {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			
			// 1. create connection
			conn = DatabaseConnection.initConnection();
			
			//create update query
			String updateQuery = "update employees "+
					"set email=?, "+
					"salary=? "+
					"where first_name=? and last_name=?";
			
			pstm = conn.prepareStatement(updateQuery);
			
			//set parameters
			pstm.setString(1, "smitha.ghanti@gmail.com");
			pstm.setDouble(2,1444444.765 );
			pstm.setString(3, "G");
			pstm.setString(4, "Ghanti");
			
			// execute query
			int rowsAffected = pstm.executeUpdate();
			
			System.out.println("The Employees No. Updated :"+rowsAffected);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
