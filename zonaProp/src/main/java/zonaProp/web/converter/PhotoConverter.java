package zonaProp.web.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zonaProp.model.repo.PhotoRepo;
import zonaProp.transfer.bussiness.Photo;

@Component
public class PhotoConverter  implements Converter<String, Photo>{
	
	PhotoRepo photos;
	
	@Autowired
	public PhotoConverter(PhotoRepo photos) {
		this.photos = photos;
	}

	public Photo convert(String source) {
		try{
		return photos.get(Integer.valueOf(source));
		} catch(NumberFormatException nfe){
			return null;
		}
	}

}
