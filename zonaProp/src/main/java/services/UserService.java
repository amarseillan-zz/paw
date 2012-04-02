package services;

import persistence.UserDAO;
import transfer.bussiness.User;

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
	

	public User createUser(transfer.bussiness.User user){
		return userDAO.createUser(user);
	}

	public boolean userAlreadyExist(transfer.bussiness.User user) {
		return userDAO.userAlreadyExist(user);
	}
	
	public User getUser(int id){
		return userDAO.getUser(id);
	}
}
