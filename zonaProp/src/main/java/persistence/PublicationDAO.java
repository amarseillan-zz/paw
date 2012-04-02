package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfer.bussiness.Publication;

public class PublicationDAO extends DAO {

	public PublicationDAO() {
		super();
	}
	
	public Publication getPublication(int pid) {
		Publication p = null;
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM PUBLICATION WHERE publicationid = ?");
			stmt.setInt(1, pid);

			ResultSet results = stmt.executeQuery();
			if (results.next()) {
				p = new Publication(results.getInt(1), results.getInt(2),
						results.getInt(3), results.getInt(4),
						results.getString(5), results.getString(6), results.getFloat(7), results.getInt(8),
						results.getFloat(9), results.getFloat(10),
						results.getInt(11), results.getBoolean(12), results.getBoolean(13), results.getBoolean(14),
						results.getBoolean(15), results.getBoolean(16),
						results.getBoolean(17), results.getString(18));
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return p;
	}

	
	
	public Publication createPublication(Publication p) {
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO PUBLICATION('userid','type','operation_type','address','city','price','environments','covered'," +
							"'uncovered','age','cable','phone','pool','living','paddle','barbecue', 'description')VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, p.getUserId());
			stmt.setInt(2, p.getType());
			stmt.setInt(3, p.getOperation_type());
			stmt.setString(4, p.getAddress());
			stmt.setString(5, p.getCity());
			stmt.setFloat(6, p.getPrice());
			stmt.setInt(7, p.getEnvironments());
			stmt.setFloat(8, p.getCovered());
			stmt.setFloat(9, p.getUncovered());
			stmt.setInt(10, p.getAge());
			stmt.setBoolean(11, p.isCable());
			stmt.setBoolean(12, p.isPhone());
			stmt.setBoolean(13, p.isPool());
			stmt.setBoolean(14, p.isLiving());
			stmt.setBoolean(15, p.isPaddle());
			stmt.setBoolean(16, p.isBarbecue());
			stmt.setString(17, p.getDescription());
			stmt.executeUpdate();

			stmt = connection.prepareStatement("SELECT PUBLICATIONID FROM SYS_USER WHERE USERID = ? AND ADDRESS = ? AND TYPE = ?");
			stmt.setInt(1, p.getUserId());
			stmt.setString(2, p.getAddress());
			stmt.setInt(3, p.getType());
			ResultSet results = stmt.executeQuery();
			if (results.next()) {
				p = new Publication( results.getInt(1),
				p.getUserId(),
				p.getType(),
				p.getOperation_type(),
				p.getAddress(),
				p.getCity(),
				p.getPrice(),
				p.getEnvironments(),
				p.getCovered(),
				p.getUncovered(),
				p.getAge(),
				p.isCable(),
				p.isPhone(),
				p.isPool(),
				p.isLiving(),
				p.isPaddle(),
				p.isBarbecue(),
				p.getDescription());
			}
			
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return p;
	}
	
	public List<Publication> getAll(int userId) {
		List<Publication> pList = new ArrayList<Publication>();
		
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM PUBLICATION WHERE USERID = ?");
			stmt.setInt(1, userId);

			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Publication p = new Publication(results.getInt(1), results.getInt(2),
						results.getInt(3), results.getInt(4),
						results.getString(5), results.getString(6), results.getFloat(7), results.getInt(8),
						results.getFloat(9), results.getFloat(10),
						results.getInt(11), results.getBoolean(12), results.getBoolean(13), results.getBoolean(14),
						results.getBoolean(15), results.getBoolean(16),
						results.getBoolean(17), results.getString(18));
				pList.add(p);
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return pList;
	}
	
	
	public void updatePublication(Publication p) {
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE PUBLICATION SET userid=?, type=?,operation_type=?,address=?,city=?,price=?,environments=?,covered=?," +
							"uncovered=?,age=?,cable=?,phone=?,pool=?,living=?,paddle=?,barbecue=?, description=? WHERE PUBLICATIONID=?");
			stmt.setInt(1, p.getUserId());
			stmt.setInt(2, p.getType());
			stmt.setInt(3, p.getOperation_type());
			stmt.setString(4, p.getAddress());
			stmt.setString(5, p.getCity());
			stmt.setFloat(6, p.getPrice());
			stmt.setInt(7, p.getEnvironments());
			stmt.setFloat(8, p.getCovered());
			stmt.setFloat(9, p.getUncovered());
			stmt.setInt(10, p.getAge());
			stmt.setBoolean(11, p.isCable());
			stmt.setBoolean(12, p.isPhone());
			stmt.setBoolean(13, p.isPool());
			stmt.setBoolean(14, p.isLiving());
			stmt.setBoolean(15, p.isPaddle());
			stmt.setBoolean(16, p.isBarbecue());
			stmt.setString(17, p.getDescription());
			stmt.setInt(18, p.getPublicationId());
			stmt.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return;
	}
	
}
