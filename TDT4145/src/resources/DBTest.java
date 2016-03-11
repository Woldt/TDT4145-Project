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
		String insrt = Tabell.Insert.Innendørsøvelse(10, "Bra", 11); 
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
