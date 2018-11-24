package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5 {

	public static void main(String[] args) {
		createTable();
	}
	
	private static void createTable() {

		String url = "jdbc:sqlite:KATA5.db";

		String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
				+ " ID integer PRIMARY KEY AUTOINCREMENT,\n"
				+ " Mail text NOT NULL);";

		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {

			stmt.execute(sql);

			System.out.println("Tabla creada");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
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
