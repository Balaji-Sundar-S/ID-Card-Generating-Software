package id_card_generator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Display_student {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/*Display_student() {
		
		conn = sql_database_connector.studentConnector();
		
		try {
			
			String sql = "select name, roll from details;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("Name\t\tRoll");
			
			while (rs.next()) {
				
				String Name = rs.getNString("Name");
				int Roll = rs.getInt("Roll");
				System.out.println(Name + "\t\t" + Roll);
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}*/
}