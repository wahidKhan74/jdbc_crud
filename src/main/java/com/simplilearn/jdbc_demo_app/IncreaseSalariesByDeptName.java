package com.simplilearn.jdbc_demo_app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class IncreaseSalariesByDeptName {

	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cstm = null;
		try {
			// 1. create connection
			conn = DatabaseConnection.initConnection();
			
			// 2. create prepare call
			cstm = conn.prepareCall("{ call increase_salaries_for_department(?,?)}");
			
			// 3. set params
			cstm.setString(1, "Engineering");
			cstm.setDouble(2, 20000);
			
			// 4. execute query
			cstm.execute();
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
				

	}

}
