package resources;


/**
 * Class for handling the sensitive database configuration information
 * @author SigveAndreEvensen
 *
 */
public class DatabaseCredentials {
	
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://mysql.stud.ntnu.no/martsti_tdt4145";  /*  jdbc:mysql://host:port/database  */
	
//  Database credentials
	private static final String USER = "martsti";
	private static final String PASS = "server123";
	
	/**
	 * @return JDBC_DRIVER string containing url to driver.
	 */
	public static String getJdbcDriver() {
		return JDBC_DRIVER;
	}

	/**
	 * @return DB_URL the url to the database 'jdbc:mysql://host:port/database'
	 */
	public static String getDbUrl() {
		return DB_URL;
	}

	/**
	 * @return USER string with the username
	 */
	public static String getUser() {
		return USER;
	}
	
	/**
	 * @return PASS string with the password for the user.
	 */
	public static String getPass(){
		return PASS;
	}
	
	

}
