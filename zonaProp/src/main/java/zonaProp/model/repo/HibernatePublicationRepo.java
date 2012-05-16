package zonaProp.model.repo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
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

	@SuppressWarnings("unchecked")
	public List<Publication> getSome(Search build) {
		List<Object> parameters = new ArrayList<Object>();
		String hql = "from Publication " + (build.isAll()? "" : "where ");
		boolean hasPrevious = false;
		Session session = getSession();
		
		if(build.getMin()!=null){
			parameters.add(build.getMin());
			hql += "price>=? ";
			hasPrevious = true;
		}
		if(build.getMax()!=null){
			parameters.add(build.getMax());
			hql += (hasPrevious? "and " : "") + "price<=? ";
			hasPrevious = true;
		}
		
		if(build.getOperationType()!=null){
			parameters.add(build.getOperationType());
			hql += (hasPrevious? "and " : "") + "operationType=? ";
			hasPrevious = true;
		}
		if(build.getPropertyType()!=null){
			parameters.add(build.getPropertyType());
			hql += (hasPrevious? "and " : "") + "propertyType=? ";
			hasPrevious = true;
		}
		
		if(build.getPublisher()!=null){
			parameters.add(build.getPublisher());
			hql += (hasPrevious? "and " : "") + "publisher=? ";
		}
		
		hql += "order by price "  + (build.isAscending()?"asc" : "desc");
		

		Query query = session.createQuery(hql);
		int i=0;
		for (Object parameter : parameters) {
			query.setParameter(i++, parameter);
		}
		
		return query.list();
	}

	@Override
	public Photo getPhoto(Integer id) {
		return get(Photo.class, id);
	}
	

	
}
