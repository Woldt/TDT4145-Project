package resources;

import application.DatabaseConnection;
import application.Tabell;;

public class DBTest {

	DatabaseConnection conn;
	
	void init(){
		conn = new DatabaseConnection();
		conn.establishConnection();
	}
	
	void run(){
		String insrt = "INSERT INTO " + Tabell.Øvelse + " VALUES(7, 'Hangups', 'Opptrekk');"; 
		conn.insert(insrt);
		conn.ovelseToString();
	}
	
	void exit(){
		conn.terminateConnection();
	}
	
	public static void main(String[] args) {
		DBTest dbt = new DBTest();
		dbt.init();
		dbt.run();
		dbt.exit();
	}
}
