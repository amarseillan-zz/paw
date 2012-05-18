package zonaProp.model.repo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import zonaProp.transfer.bussiness.Photo;
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
	
	public Publication get(int publicationId) {
		return get(Publication.class, publicationId);
	}

	public void add(Publication publication) {
		save(publication);	
	}

	public List<Publication> getSome(Search build) {
		List<Object> parameters = new ArrayList<Object>();
		String hql = "from Publication where active = true ";
		
		if(build.getMin()!=null){
			parameters.add(build.getMin());
			hql += "and price>=? ";
		}
		if(build.getMax()!=null){
			parameters.add(build.getMax());
			hql += "and price<=? ";
		}
		
		if(build.getOperationType()!=null){
			parameters.add(build.getOperationType());
			hql += "and operationType=? ";
		}
		if(build.getPropertyType()!=null){
			parameters.add(build.getPropertyType());
			hql += "and propertyType=? ";
		}
		
		if(build.getPublisher()!=null){
			parameters.add(build.getPublisher());
			hql += "and publisher=? ";
		}
		
		hql += "order by price "  + (build.isAscending()?"asc" : "desc");

		return find(hql,parameters.toArray());
	}

	public Photo getPhoto(Integer id) {
		return get(Photo.class, id);
	}
	

	
}
