package zonaProp.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zonaProp.services.PublicationService;
import zonaProp.transfer.bussiness.Publication;



@Component
public class PublicationConverter implements Converter<String, Publication>{
	
//	private StudentService service;
	PublicationService ps = PublicationService.getInstance();
//	@Autowired
//	public StudentConverter(StudentService service) {
//		this.service = service;
//	}

	public Publication convert(String source) {
		return ps.getPublication(Integer.valueOf(source));
	}

}
