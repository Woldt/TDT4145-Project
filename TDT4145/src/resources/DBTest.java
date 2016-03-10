package resources;

import application.DatabaseConnection;;

public class DBTest {

	DatabaseConnection conn;
	
	void init(){
		conn = new DatabaseConnection();
		conn.establishConnection();
	}
	
	void run(){
		String insrt = "INSERT INTO Øvelse VALUES(1, 'Push up', 'Opptrekk');"; 
		conn.insert(insrt);
		conn.ovelseToString();
	}
	
	public static void main(String[] args) {
		DBTest dbt = new DBTest();
		dbt.init();
		dbt.run();
	}
}
