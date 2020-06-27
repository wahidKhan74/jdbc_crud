package com.simplilearn.jdbc_demo_app;

import java.sql.Statement;

public class DeleteEmployee {

	public static void main(String[] args) {
		try {
			System.out.println("Create Statement");
			Statement stm = DatabaseConnection.initConnection().createStatement();
			
			// create delete query
			String deleteQuery = "delete from employees "+
			"where last_name='David' and id='6'";
			
			int rowsAftted = stm.executeUpdate(deleteQuery);
			System.out.println("No of records deleted "+rowsAftted);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
