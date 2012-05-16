package zonaProp.web.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zonaProp.model.repo.PublicationRepo;
import zonaProp.transfer.bussiness.Photo;

@Component
public class PhotoConverter  implements Converter<String, Photo>{
	
	PublicationRepo publications;
	
	@Autowired
	public PhotoConverter(PublicationRepo publications) {
		this.publications = publications;
	}

	public Photo convert(String source) {
		try{
		return publications.getPhoto(Integer.valueOf(source));
		} catch(NumberFormatException nfe){
			return null;
		}
	}

}
