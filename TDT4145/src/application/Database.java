package application;

import java.util.ArrayList;

/**
 * 
 * @author Martin Stigen
 *
 */
public class Database {
	
	private static DatabaseConnection connection;
	
	public static void insert(String query) {
		Database.init();
		connection.insert(query);
		Database.exit();
	}
	
	public static ArrayList<String> select(String query) {
		Database.init();
		ArrayList<String> result = connection.select(query);
		Database.exit();
		return result;
	}
	
	private static void init(){
		connection = new DatabaseConnection();
		connection.establishConnection();
	}
	
	
	private static  void exit(){
		connection.terminateConnection();
	}
	
}
