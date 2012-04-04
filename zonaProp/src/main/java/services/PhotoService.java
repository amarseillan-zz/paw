package services;


import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import persistence.PhotoDAO;
import transfer.bussiness.Photo;


public class PhotoService {

	private static PhotoService instance;
	PhotoDAO photoDAO;
	private static final int MAX_PHOTO_SIZE = 500000;
	
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
	
	public List<Photo> getPhotosByPublicationId(int publicationId) {
		return this.photoDAO.getPhotosByPublicationId(publicationId);		
	}

	public Photo createPhotoFromFileItem(FileItem fileItem, int publicationId) throws IOException {
		int size = (int) fileItem.getSize();
		if(size > MAX_PHOTO_SIZE){
			throw new InvalidParameterException("Tamaño del archivo demasiado grande");
		}
		byte[] imageBytes = new byte[size];
		fileItem.getInputStream().read(imageBytes, 0, imageBytes.length);
		Photo image = new Photo(0, publicationId, imageBytes);
		
		return image;
	}
	

}
