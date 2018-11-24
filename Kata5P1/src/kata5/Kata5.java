package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5 {

	public static void main(String[] args) {
		selectAll();
	}

	private static Connection connect() {

		final String url = "jdbc:sqlite:KATA5.db";
		
		Connection conn = null;
		
		try {
			
			conn = DriverManager.getConnection(url);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}


	private static void selectAll() {
		
		String sql = "SELECT * FROM PEOPLE";
		
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				System.out.printf("ID: %d | Name: %s | Surname: %s | Department: %s\n",
						rs.getInt("ID"), rs.getString("Name"),
						rs.getString("Surname"), rs.getString("Department"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
