package zonaProp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zonaProp.transfer.bussiness.Photo;
import zonaProp.transfer.bussiness.OperationType;
import zonaProp.transfer.bussiness.PropertyServices;
import zonaProp.transfer.bussiness.PropertyType;
import zonaProp.transfer.bussiness.Publication;
import zonaProp.transfer.bussiness.Search;

public class PublicationDAO extends DAO {
	public static final int EMPTY=-1;
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
						PropertyType.values()[results.getInt(3)-1], OperationType.values()[results.getInt(4)-1],
						results.getString(5), results.getString(6), results.getFloat(7), results.getInt(8),
						results.getFloat(9), results.getFloat(10),
						results.getInt(11), new ArrayList<PropertyServices>(), results.getString(18), results.getBoolean(19));
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return p;
	}


	
	private void createPublication(Publication p, int userId) {

		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO PUBLICATION(userid,type,operation_type,address,city,price,environments,covered," +
							"uncovered,age,cable,phone,pool,living,paddle,barbecue, description, active)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, userId);
			stmt.setInt(2, p.getPropertyType().getNumber());
			stmt.setInt(3, p.getOperationType().getNumber());
			stmt.setString(4, p.getAddress());
			stmt.setString(5, p.getCity());
			stmt.setFloat(6, (float)p.getPrice());
			stmt.setInt(7, p.getEnvironments());
			stmt.setFloat(8, (float)p.getCovered());
			stmt.setFloat(9, (float)p.getUncovered());
			stmt.setInt(10, p.getAge());
			stmt.setBoolean(11, false);
			stmt.setBoolean(12, false);
			stmt.setBoolean(13, false);
			stmt.setBoolean(14, false);
			stmt.setBoolean(15, false);
			stmt.setBoolean(16, false);
			stmt.setString(17, p.getDescription());
			stmt.setBoolean(18, p.isActive());
			stmt.executeUpdate();

			stmt = connection.prepareStatement("SELECT PUBLICATIONID FROM PUBLICATION WHERE USERID = ? AND ADDRESS = ? AND TYPE = ?");
			stmt.setInt(1, userId);
			stmt.setString(2, p.getAddress());
			stmt.setInt(3, p.getPropertyType().getNumber());
			ResultSet results = stmt.executeQuery();
			if (results.next()) {
				p = new Publication( results.getInt(1),
						p.getUserId(),
						PropertyType.values()[p.getPropertyType().getNumber()-1],
						OperationType.values()[p.getOperationType().getNumber()-1],
						p.getAddress(),
						p.getCity(),
						p.getPrice(),
						p.getEnvironments(),
						p.getCovered(),
						p.getUncovered(),
						p.getAge(),
						new ArrayList<PropertyServices>(),
						p.getDescription(),
						p.isActive());
			}

			connection.commit();

			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return;
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
				Publication 	p = new Publication(results.getInt(1), results.getInt(2),
						PropertyType.values()[results.getInt(3)-1], OperationType.values()[results.getInt(4)-1],
						results.getString(5), results.getString(6), results.getFloat(7), results.getInt(8),
						results.getFloat(9), results.getFloat(10),
						results.getInt(11), new ArrayList<PropertyServices>(), results.getString(18), results.getBoolean(19));
				pList.add(p);
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return pList;
	}

	public List<Publication> advancedSearch(Search s) {
		List<Publication> pList = new ArrayList<Publication>();

		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt ;
			
			stmt=connection
					.prepareStatement(s.statment());

			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Publication 	p = new Publication(results.getInt(1), results.getInt(2),
						PropertyType.values()[results.getInt(3)-1], OperationType.values()[results.getInt(4)-1],
						results.getString(5), results.getString(6), results.getFloat(7), results.getInt(8),
						results.getFloat(9), results.getFloat(10),
						results.getInt(11), new ArrayList<PropertyServices>(), results.getString(18), results.getBoolean(19));
				pList.add(p);
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return pList;
	}

	private void updatePublication(Publication p) {
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE PUBLICATION SET userid=?, type=?,operation_type=?,address=?,city=?,price=?,environments=?,covered=?," +
							"uncovered=?,age=?,cable=?,phone=?,pool=?,living=?,paddle=?,barbecue=?, description=?, active=? WHERE PUBLICATIONID=?");
			stmt.setInt(1, p.getUserId());
			stmt.setInt(2, p.getPropertyType().getNumber());
			stmt.setInt(3, p.getOperationType().getNumber());
			stmt.setString(4, p.getAddress());
			stmt.setString(5, p.getCity());
			stmt.setFloat(6, (float)p.getPrice());
			stmt.setInt(7, p.getEnvironments());
			stmt.setFloat(8, (float)p.getCovered());
			stmt.setFloat(9, (float)p.getUncovered());
			stmt.setInt(10, p.getAge());
			stmt.setBoolean(11, false);
			stmt.setBoolean(12, false);
			stmt.setBoolean(13, false);
			stmt.setBoolean(14, false);
			stmt.setBoolean(15, false);
			stmt.setBoolean(16, false);
			stmt.setString(17, p.getDescription());
			stmt.setBoolean(18, p.isActive());
			stmt.setInt(19, p.getPublicationId());
			stmt.executeUpdate();

			connection.commit();
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return;
	}

	
	public void save(Publication p, int userId){
		if( p.getPublicationId() == -1 ){
			createPublication(p, userId);
		}else{
			updatePublication(p);
		}
	}
	
	public void uploadPhoto(Photo image) {
		try{
	    	Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO PHOTO(PUBLICATIONID, PHOTO)VALUES(?,?)");
			stmt.setInt(1, image.getPublicationId());
			stmt.setBytes(2, image.getImageBytes());
			
			stmt.executeUpdate();
			connection.commit();
			connection.close();
			
			
    	}catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		
	}

	public List<Photo> getPhotosByPublication(Publication p) {
		List<Photo> pList = new ArrayList<Photo>();

		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM PHOTO WHERE PUBLICATIONID = ?");
			stmt.setInt(1, p.getPublicationId());

			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Photo photo = new Photo(results.getInt(1), results.getInt(2), results.getBinaryStream(3));
				pList.add(photo);
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return pList;
		
	}

	public Photo getPhotoById(Integer imageId) {
		Photo photo = null;

		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM PHOTO WHERE PHOTOID = ?");
			stmt.setInt(1, imageId);

			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				photo = new Photo(results.getInt(1), results.getInt(2), results.getBinaryStream(3));
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return photo;
	}

	public void deletePhoto(Photo photo) {		
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM PHOTO WHERE PHOTOID = ?");
			stmt.setInt(1, photo.getId());
			stmt.executeUpdate();
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		
	}
}
