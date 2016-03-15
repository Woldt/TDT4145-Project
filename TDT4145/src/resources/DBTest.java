package resources;

import application.Database;
import application.DatabaseConnection;
import application.Tabell;;

public class DBTest {

	DatabaseConnection conn;
	
	void init(){
		conn = new DatabaseConnection();
		conn.establishConnection();
	}
	
	void run(){
		System.out.println(Tabell.SELECT.INNENDØRSØVELSE());
		System.out.println(conn.select(Tabell.SELECT.INNENDØRSØVELSE()));
	}
	
	void exit(){
		conn.terminateConnection();
	}
	
	public static void main(String[] args) {
		Database.insert("INSERT INTO Treningsøkt VALUES(DEFAULT, '2016-03-16', '10:45', 90, 3, 3, 'Jeg er glad')");
	}
}
