package zonaProp.services;


import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import zonaProp.persistence.PhotoDAO;
import zonaProp.transfer.bussiness.Photo;


public class PhotoService {

	private static PhotoService instance;
	PhotoDAO photoDAO;
	private static final int MAX_PHOTO_SIZE = 5000000;
	
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
			throw new InvalidParameterException("Tamaño del archivo demasiado grande.");
		}
		if(size == 0){
			throw new InvalidParameterException("Debe seleccionar una imagen.");
		}
		if(!validExtension(fileItem.getName())){
			throw new InvalidParameterException("Formato de imagen invalido.");			
		}
		Photo image = new Photo(0, publicationId, fileItem.getInputStream());
		
		return image;
	}

	private boolean validExtension(String name) {		
		String[] aux = name.split("\\.");
		if(aux.length > 0){
			String extension =  aux[aux.length-1];
			if(extension.equals("bmp") || extension.equals("png") || extension.equals("jpg")){
				return true;
			}
		}
		return false;
	}

	public Photo getPhotoById(Integer imageId) {
		return this.photoDAO.getPhotoById(imageId);
	}

	public void deletePhotoById(int imageId) {
		this.photoDAO.deletePhotoById(imageId);
	}
	

}
