package application;

import java.sql.*;
import resources.DatabaseCredentials;
/**
 * @author SigveAndreEvensen
 * Class for connecting to MySQL using JDBC.
 */

public class DatabaseConnection {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = DatabaseCredentials.getJdbcDriver();  
	static final String DB_URL = DatabaseCredentials.getDbUrl();

	//  Database credentials
	static final String USER = DatabaseCredentials.getUser();
	static final String PASS = DatabaseCredentials.getPass();

	private Connection conn = null;
	private Statement stmt = null;
	
	private ResultSet rs;

	/**
	 * Establishes connection to MySQL database using JDBC
	 * Class.forName register JDBC Driver
	 * conn tries to establish the physical connection
	 */
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
	
	/**
	 * Method to execute SQL-query statement. 
	 * Prints SQLEceptions if thrown.
	 * @param query Complete SQL-query statement.
	 */
	private void executeQuery(String query){
		//STEP 4: Execute a query
		System.out.println("Creating statement...");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			System.out.println(e);;
		}
		
	}
	
	/**
	 * Method to handle the resultTabel generated from executeQuery(String query)
	 */
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
	
	/**
	 * Terminates the established connection
	 * Closes stmt, and conn.
	 */
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
