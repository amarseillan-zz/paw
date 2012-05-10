package zonaProp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zonaProp.transfer.bussiness.Photo;
import zonaProp.transfer.bussiness.Publication;

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

	public List<Photo> getPhotosByPublication(Publication p) {
		List<Photo> pList = new ArrayList<Photo>();

		try {
			Connection connection = manager.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM PHOTO WHERE PUBLICATIONID = ?");
			stmt.setInt(1, p.getId());

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
