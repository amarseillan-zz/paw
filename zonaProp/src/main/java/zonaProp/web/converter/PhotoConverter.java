package zonaProp.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zonaProp.services.PublicationService;
import zonaProp.transfer.bussiness.Photo;

@Component
public class PhotoConverter  implements Converter<String, Photo>{

	PublicationService ps = PublicationService.getInstance();

	@Autowired
	public PhotoConverter(PublicationService ps) {
		this.ps = ps;
	}

	public Photo convert(String source) {
		return ps.getPhotoById(Integer.valueOf(source));
	}

}
