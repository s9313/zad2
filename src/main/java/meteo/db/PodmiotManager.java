package meteo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PodmiotManager {

	private Connection connection;
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	private String createTablePerson = "CREATE TABLE Operator(id bigint GENERATED BY DEFAULT AS IDENTITY, name varchar(20))";

	private PreparedStatement addPersonStmt;
	private PreparedStatement deleteAllPersonsStmt;
	private PreparedStatement getAllPersonsStmt;

	private Statement statement;

	public PodmiotManager() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Podmiot".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createTablePerson);

			addPersonStmt = connection
					.prepareStatement("INSERT INTO Operator (name) VALUES (?)");
			deleteAllPersonsStmt = connection
					.prepareStatement("DELETE FROM Operator");
			getAllPersonsStmt = connection
					.prepareStatement("SELECT id, name FROM Operator");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() {
		return connection;
	}
	
	void clearPersons() {
		try {
			deleteAllPersonsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int addPerson(Operator operator) {
		int count = 0;
		try {
			addPersonStmt.setString(1, operator.getName());

			count = addPersonStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Operator> getAllPersons() {
		List<Operator> persons = new ArrayList<Operator>();

		try {
			ResultSet rs = getAllPersonsStmt.executeQuery();

			while (rs.next()) {
				Operator p = new Operator();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				persons.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persons;
	}

}