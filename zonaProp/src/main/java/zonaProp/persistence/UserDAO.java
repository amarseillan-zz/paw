package zonaProp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import zonaProp.transfer.bussiness.User;

public class UserDAO extends DAO {

	public UserDAO() {
		super();
	}

	public User getUser(int id) {
		User user = null;
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM SYS_USER WHERE userid = ?");
			stmt.setInt(1, id);

			ResultSet results = stmt.executeQuery();
			if (results.next()) {
				user = new User(id, results.getString(2), results.getString(3),
						results.getString(4), results.getString(5),
						results.getString(6), results.getString(7));
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return user;
	}

	public User authenticate(String username, String password) {
		User user = null;
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM SYS_USER WHERE nick = ? AND password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet results = stmt.executeQuery();
			if (results.next()) {
				user = new User(results.getInt(1), results.getString(2), results.getString(3),
						results.getString(4), results.getString(5),
						username, password);
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return user;
	}

	public boolean userAlreadyExist(String username) {
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM SYS_USER WHERE NICK = ?");
			stmt.setString(1, username);
			ResultSet results = stmt.executeQuery();
			if (results.next()) {
				return true;
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return false;
	}
	
	public User createUser(zonaProp.transfer.bussiness.User user) {
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO SYS_USER(NAME, LASTNAME, EMAIL, PHONE, NICK, PASSWORD)VALUES(?,?,?,?,?,?)");
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPhone());
			stmt.setString(5, user.getUsername());
			stmt.setString(6, user.getPassword());
			stmt.executeUpdate();

			stmt = connection.prepareStatement("SELECT USERID FROM SYS_USER WHERE NICK = ? AND PASSWORD = ?");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			ResultSet results = stmt.executeQuery();
			if (results.next()) {
				user = new User(results.getInt(1), user.getName(), user.getLastName(),
						user.getEmail(), user.getPhone(),
						user.getUsername(), user.getPassword());
			}
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return user;
	}
}
