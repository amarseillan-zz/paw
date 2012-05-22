package zonaProp.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zonaProp.model.repo.PublicationRepo;
import zonaProp.transfer.bussiness.Environment;



@Component
public class EnvironmentConverter implements Converter<String, Environment>{
	
	
	PublicationRepo publications;
	
	@Autowired
	public EnvironmentConverter(PublicationRepo publications) {
		this.publications = publications;
	}

	public Environment convert(String source) {
		return publications.getEnvironment(Integer.valueOf(source));
	}

}
