package de.bas.devcamp.jdbc.jdbc;

import de.bas.devcamp.jdbc.Util;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class JdbcApplication {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "lukas123");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from coffee");

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				Util.printEntry(id, name, price);
			}
		} catch (SQLException sqle) {
			System.err.println("SQL Exception thrown while making connection");
			System.err.println("Exception: " + sqle.getMessage());
		}
		finally {
			connection.close();
		}
	}
}
