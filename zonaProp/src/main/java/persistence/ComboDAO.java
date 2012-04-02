package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfer.forms.Combo;

public class ComboDAO extends DAO {

	public ComboDAO() {
		super();
	}

	public List<Combo> getTypes() {
		 List<Combo> cList = new ArrayList<Combo>();
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM PROPERTY_TYPE");

			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Combo c = new Combo(results.getInt(1), results.getString(2));
				cList.add(c);
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return cList;
	}
	
	public List<Combo> getOperationTypes() {
		 List<Combo> cList = new ArrayList<Combo>();
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM OPERATION_TYPE");

			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Combo c = new Combo(results.getInt(1), results.getString(2));
				cList.add(c);
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return cList;
	}
}
