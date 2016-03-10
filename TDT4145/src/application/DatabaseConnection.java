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
	
	
	PreparedStatement preparedStatement;
	
	private ResultSet rs;

	/**
	 * Establishes connection to MySQL database using JDBC
	 * Class.forName register JDBC Driver
	 * conn tries to establish the physical connection
	 */
	public void establishConnection(){	
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

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
	public void insert(String query){
		//STEP 4: Execute a query
		System.out.println("Creating statement...");
		try {
			stmt = conn.createStatement();
			preparedStatement = conn.prepareStatement(query);
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e);;
		}
		
	}
	
	/**
	 * Method to handle the resultTabel generated from executeQuery(String query)
	 */
	public void ovelseToString(){
		//STEP 5: Extract data from result set
		try {	//Display or do something with values
			stmt = conn.createStatement();
			String query = "SELECT * FROM Øvelse"; 
			rs = stmt.executeQuery(query);		
			while(rs.next()){
				//get attributes.
				int ID = rs.getInt("ØvelsesID");
				String name = rs.getString("Navn");
				String desc = rs.getString("Beskrivelse");
				
				//Display tuple.
				String tupel = "ID: " + ID + "\nName: " + name + "\nDescription: " + desc;
				System.out.println(tupel);
			}
		} catch (Exception e) {
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
