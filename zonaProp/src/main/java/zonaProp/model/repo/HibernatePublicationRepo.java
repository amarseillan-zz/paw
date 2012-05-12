package zonaProp.model.repo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import zonaProp.transfer.bussiness.Publication;
import zonaProp.transfer.bussiness.Search;

@Component
@Repository
public class HibernatePublicationRepo extends AbstractHibernateRepo implements PublicationRepo {

	@Autowired
	public HibernatePublicationRepo(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public List<Publication> getAll() {
		return find("from Publication");
	}
	
	public Publication get(int userId) {
		//TODO esto esta mal. el id tiene que ser el de publication para buscarlo con get
		return get(Publication.class, userId);
	}

	public void add(Publication publication) {
		save(publication);	
	}

	public List<Publication> getSome(Search build) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
