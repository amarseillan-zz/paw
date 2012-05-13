package zonaProp.web.command;

import java.io.IOException;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import zonaProp.transfer.bussiness.Photo;



public class PhotoForm {
	
	  private CommonsMultipartFile fileData;
	 
	 
	  public CommonsMultipartFile getFileData()
	  {
	    return fileData;
	  }
	 
	  public void setFileData(CommonsMultipartFile fileData)
	  {
	    this.fileData = fileData;
	  }
	  
	  public Photo build(){
		Photo image = null; 
		try {
			image = new Photo(0, fileData.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	  }
	  
	}
