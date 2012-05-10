package zonaProp.web.command;

import java.io.IOException;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import zonaProp.transfer.bussiness.Photo;
import zonaProp.transfer.bussiness.Publication;



public class PhotoForm {
	
	  private Publication publication;
	  private CommonsMultipartFile fileData;
	 
	  public Publication getPublication()
	  {
	    return publication;
	  }
	 
	  public void setPublication(Publication publication)
	  {
	    this.publication = publication;
	  }
	 
	  public CommonsMultipartFile getFileData()
	  {
	    return fileData;
	  }
	 
	  public void setFileData(CommonsMultipartFile fileData)
	  {
	    this.fileData = fileData;
	  }
	  
	  public Photo getPhoto(){
		Photo image = null; 
		try {
			image = new Photo(0, publication.getId(), fileData.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	  }
	  
	}
