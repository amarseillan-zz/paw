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
}
