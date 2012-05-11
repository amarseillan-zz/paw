package zonaProp.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zonaProp.model.repo.PublicationRepo;
import zonaProp.transfer.bussiness.Publication;



@Component
public class PublicationConverter implements Converter<String, Publication>{
	
	PublicationRepo publications;
	
	@Autowired
	public PublicationConverter(PublicationRepo publications) {
		this.publications = publications;
	}

	public Publication convert(String source) {
		try{
		return publications.get(Integer.valueOf(source));
		} catch(NumberFormatException nfe){
			return null;
		}
	}

}
