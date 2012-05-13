package zonaProp.web.converter;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import zonaProp.transfer.bussiness.Photo;


public class PhotoConverter  implements Converter<String, Photo>{
	
	private final SessionFactory sessionFactory;

	@Autowired
	public PhotoConverter(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Photo convert(String source) {
		return (Photo)sessionFactory.getCurrentSession().get(Photo.class, Integer.parseInt(source));
	}

}
