package zonaProp.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;


public abstract class AbstractHibernateRepo {
	private final SessionFactory sessionFactory;

	public AbstractHibernateRepo(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> type, Serializable id) {
		return (T) getSession().get(type, id);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> find(Class<T> c,List<Criterion> l, Order order) {
		Criteria criteria = getSession().createCriteria(c);
		for (Criterion criterion : l) {
			criteria.add(criterion);
		}
		criteria.addOrder(order);
		return criteria.list();
	}

	
	protected org.hibernate.classic.Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Serializable save(Object o) {
		return getSession().save(o);
	}

}
