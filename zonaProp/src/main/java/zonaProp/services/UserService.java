package zonaProp.services;


import org.springframework.stereotype.Service;

import zonaProp.persistence.UserDAO;
import zonaProp.transfer.bussiness.User;

@Service
public class UserService {

	private static UserService instance;
	UserDAO userDAO;
	
	public static synchronized UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	private UserService() {
		this.userDAO = new UserDAO();
	}
	
	public User authenticate(String username, String password){
		return userDAO.authenticate(username, password);
	}
	

	public User createUser(zonaProp.transfer.bussiness.User user){
		return userDAO.createUser(user);
	}

	public boolean userAlreadyExist(String username) {
		return userDAO.userAlreadyExist(username);
	}
	
	public User getUser(int id){
		return userDAO.getUser(id);
	}
	
	public User createNewUser(User user){
		
		user = createUser(user);
		
		if(user.getId() == 0)
			return null;
		
		return user;		
	}
}
