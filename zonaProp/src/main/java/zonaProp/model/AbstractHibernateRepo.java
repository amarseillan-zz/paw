package zonaProp.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;


public abstract class AbstractHibernateRepo {
	private final SessionFactory sessionFactory;
	

	public AbstractHibernateRepo(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> type, Serializable id) {
		return (T) getSession().get(type, id);
	}
	
	
	public <T> List<T> find(Class<T> c,List<Criterion> l, Order order) {
		return find(c,l,order,0,Integer.MAX_VALUE);
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> find(Class<T> c,List<Criterion> l, Order order, int firstResult, int maxResults) {
		Criteria criteria = getSession().createCriteria(c);
		for (Criterion criterion : l) {
			criteria.add(criterion);
		}
		criteria.addOrder(order);
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);
		return criteria.list();
	}

	public <T> Long count(Class<T> c,List<Criterion> l){
		Criteria criteria = getSession().createCriteria(c);
		for (Criterion criterion : l) {
			criteria.add(criterion);
		}
		criteria.setProjection(Projections.rowCount());
		
		return (Long)criteria.uniqueResult();
	}
	
	protected org.hibernate.classic.Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Serializable save(Object o) {
		return getSession().save(o);
	}

}
