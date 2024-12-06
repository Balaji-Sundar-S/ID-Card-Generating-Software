package id_card_generator;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class sql_database_connector extends Student{
	
	
	public static void studentConnector() {
		
		Database_connection.DBConn();
	}
	
	public static void staffConnector() {
		
		Database_connection.DBConn();
	}
}