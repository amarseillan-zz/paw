package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transfer.bussiness.Photo;

public class PhotoDAO extends DAO {

	public PhotoDAO() {
		super();
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

	public List<Photo> getPhotosByPublicationId(int publicationId) {
		List<Photo> pList = new ArrayList<Photo>();

		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM PHOTO WHERE PUBLICATIONID = ?");
			stmt.setInt(1, publicationId);

			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Photo p = new Photo(results.getInt(1), results.getInt(2), results.getBytes(3), results.getBinaryStream(3));
				pList.add(p);
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
				photo = new Photo(results.getInt(1), results.getInt(2), results.getBytes(3), results.getBinaryStream(3));
			}
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		return photo;
	}

	public void deletePhotoById(int imageId) {		
		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM PHOTO WHERE PHOTOID = ?");
			stmt.setInt(1, imageId);
			stmt.executeUpdate();
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage(), e);
		}
		
	}
}
