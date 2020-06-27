package com.simplilearn.jdbc_demo_app;

import java.sql.Statement;

public class UpdateEmployee {

	public static void main(String[] args) {
		try {
			System.out.println("Create Statement");
			Statement stm = DatabaseConnection.initConnection().createStatement();
			
			String updateQuery = "update employees "+
			"set email='john.smith@gmail.com', "+
			"salary='45555.189' "+
			"where first_name='John' and last_name='Smith'";
			
			int rowsAffected = stm.executeUpdate(updateQuery);
			
			System.out.println("The No of Rows Affected :"+rowsAffected);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
