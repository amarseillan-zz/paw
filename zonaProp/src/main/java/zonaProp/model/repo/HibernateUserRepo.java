package zonaProp.model.repo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import zonaProp.transfer.bussiness.User;

@Component
@Repository
public class HibernateUserRepo extends AbstractHibernateRepo implements UserRepo {

	@Autowired
	public HibernateUserRepo(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public List<User> getAll() {
		return find("from User");
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
		return !find("from User where username = ?", username).isEmpty();
	}

	public boolean authenticate(String username, String password) {
		return !find("from User where username = ? AND password = ?", username, password).isEmpty();
	}

	public User get(String username) {
		return (User) find("from User where username = ?", username).get(0);
	}
}
