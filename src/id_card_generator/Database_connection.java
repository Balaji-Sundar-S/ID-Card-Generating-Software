package id_card_generator;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Database_connection {
	Connection conn = null;
	public static Connection DBConn () {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j_mini_project", "root", "Balaji.mysql@28");
			JOptionPane.showMessageDialog(null, "Connection successful");
			return conn;
			
		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
