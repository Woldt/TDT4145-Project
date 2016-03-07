package application;

import java.sql.*;

public class DatabaseConnection {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://mysql.stud.ntnu.no/martsti_tdt4145";  /*  jdbc:mysql://host:port/database  */

	//  Database credentials
	static final String USER = "username";
	static final String PASS = "password";

	private Connection conn = null;
	private Statement stmt = null;
	
	private ResultSet rs;

	private void establishConnection(){	
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	
	private void executeQuery(String query){
		//STEP 4: Execute a query
		System.out.println("Creating statement...");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void resultToString(){
		//STEP 5: Extract data from result set
		try {
			while(rs.next()){
				//Retrieve by column name
			/*
			 	to retrieve int use rs.getInt("attributeName")
				to retrieve String use rs.getString("attributeName")
				to retrieve Time use rs.getTime(columnIndex or "attributeName")
			 */				
				
				
				//Display or do something with values

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void terminateConnection(){
		//STEP 6: Clean-up environment
		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException se2){
		}// nothing we can do
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	

}
