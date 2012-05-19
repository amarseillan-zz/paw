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

import zonaProp.transfer.bussiness.RealEstate;
import zonaProp.transfer.bussiness.User;

@Component
@Repository
public class HibernateUserRepo extends AbstractHibernateRepo implements UserRepo {

	@Autowired
	public HibernateUserRepo(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public List<User> getAll() {
		return find(User.class, new ArrayList<Criterion>(),Order.asc("username"));
	}
	
	public User get(int userId) {
		return get(User.class, userId);
	}

	public void add(User user) throws DuplicatedUserException {
		if (existsUsername(user.getUsername())) {
			throw new DuplicatedUserException();
		}
		save(user);
		
	}
	private boolean existsUsername(String username) {
		List<Criterion> restrictions = new ArrayList<Criterion>();
		restrictions.add(Restrictions.eq("username", username));
		return !find(User.class,restrictions,Order.asc("username")).isEmpty();
	}

	public boolean authenticate(String username, String password) {
		if(username == null || password == null)
			return false;
		List<Criterion> restrictions = new ArrayList<Criterion>();
		restrictions.add(Restrictions.eq("username", username));
		restrictions.add(Restrictions.eq("password", password));
		return !find(User.class,restrictions,Order.asc("username")).isEmpty();
	}

	public User get(String username) {
		List<Criterion> restrictions = new ArrayList<Criterion>();
		restrictions.add(Restrictions.eq("username", username));
		return (User) find(User.class,restrictions,Order.asc("username")).get(0);
	}

	public List<RealEstate> getRealStates() {
		return find(RealEstate.class, new ArrayList<Criterion>(),Order.asc("username"));
	}
}
