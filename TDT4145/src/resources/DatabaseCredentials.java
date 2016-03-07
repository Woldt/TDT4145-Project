package resources;

public class DatabaseCredentials {
	
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://mysql.stud.ntnu.no/martsti_tdt4145";  /*  jdbc:mysql://host:port/database  */
	
//  Database credentials
	private static final String USER = "username";
	private static final String PASS = "password";
	
	
	public static String getJdbcDriver() {
		return JDBC_DRIVER;
	}

	public static String getDbUrl() {
		return DB_URL;
	}

	public static String getUser() {
		return USER;
	}
	
	public static String getPass(){
		return PASS;
	}
	
	

}
