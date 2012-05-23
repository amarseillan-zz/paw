package zonaProp.model.publication;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import zonaProp.model.AbstractHibernateRepo;
import zonaProp.model.photo.Photo;
import zonaProp.model.photo.PhotoRepo;


@Component
@Repository
public class HibernatePhotoRepo extends AbstractHibernateRepo implements
		PhotoRepo {

	@Autowired
	public HibernatePhotoRepo(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public Photo get(int id) {
		return get(Photo.class, id);
	}

}
