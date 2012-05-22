package zonaProp.model.repo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
		return find(Publication.class, new ArrayList<Criterion>(), Order.asc("price"));
	}

	public Publication get(int publicationId) {
		return get(Publication.class, publicationId);
	}

	public void add(Publication publication) {
		save(publication);	
	}

	public List<Publication> getSome(Search build) {
		
		List<Criterion> restrictions =new ArrayList<Criterion>();
		restrictions.add(Restrictions.eq("active", true));
		if(build.getMin()!=null){
			if(build.getMax()!=null){
				restrictions.add(Restrictions.between("price", build.getMin(), build.getMax()));
			}else{
				restrictions.add(Restrictions.ge("price", build.getMin()));
			}
		}else{
			if(build.getMax()!=null){
				restrictions.add(Restrictions.le("price", build.getMax()));
			}
		}

		if(build.getOperationType()!=null){
			restrictions.add(Restrictions.eq("operationType", build.getOperationType()));
		}

		if(build.getPropertyType()!=null){
			restrictions.add(Restrictions.eq("propertyType",build.getPropertyType()));
		}

		if(build.getPublisher()!=null){
			restrictions.add(Restrictions.eq("publisher",build.getPublisher()));
		}

		Order order = build.isAscending()?Order.asc("price"):Order.desc("price");

		return find(Publication.class, restrictions, order);
	}

}
