package zonaProp.services;


import java.util.List;

import zonaProp.persistence.PhotoDAO;
import zonaProp.transfer.bussiness.Photo;
import zonaProp.transfer.bussiness.Publication;

@Deprecated
public class PhotoService {

	private static PhotoService instance;
	PhotoDAO photoDAO;
	
	public static synchronized PhotoService getInstance() {
		if (instance == null) {
			instance = new PhotoService();
		}
		return instance;
	}
	
	private PhotoService() {
		this.photoDAO = new PhotoDAO();
	}

	public void uploadPhoto(Photo image) {
		this.photoDAO.uploadPhoto(image);		
	}
	
	public List<Photo> getPhotosByPublication(Publication p) {
		return this.photoDAO.getPhotosByPublication(p);		
	}

	public Photo getPhotoById(Integer imageId) {
		return this.photoDAO.getPhotoById(imageId);
	}

	public void deletePhoto(Photo image) {
		this.photoDAO.deletePhoto(image);
	}
	

}
