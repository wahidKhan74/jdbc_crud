package com.simplilearn.jdbc_demo_app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class GetCountForDepartment {

	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cstm = null;
		try {
			// 1. Create connection
			conn = DatabaseConnection.initConnection();
			
			// 2. Create callablestm
			cstm = conn.prepareCall("{call get_count_for_department(?,?)}");
			
			// 3. Set Parameters
			// IN
			String department = "HR";
			cstm.setString(1, department);
			// OUT
			cstm.registerOutParameter(2, Types.INTEGER);
			
			
			//4. execute query
			cstm.execute();
			
			// Fetch Out result
			int theCount = cstm.getInt(2);
			System.out.println("The Employee Count for Department "+ department +" is ," +theCount);
			
			
		}catch (Exception e) {
			
		}

	}

}
