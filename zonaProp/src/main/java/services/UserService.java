package services;

import java.security.InvalidParameterException;

import exceptions.DuplicatedUsernameException;
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
	
	public User createNewUser(String name, String lastName, String email,
			String phone, String username, String password1, String password2)
			throws DuplicatedUsernameException, InvalidParameterException {
		
		if(!User.validParams(name, lastName, email, phone, username, password1, password2)){
			throw new InvalidParameterException();
		}
		
		User user = new User(0, name, lastName, email, phone, username, password1);	
		
		if(userAlreadyExist(user)){
			throw new DuplicatedUsernameException();			
		}
		
		user = createUser(user);
		
		if(user.getId() == 0)
			return null;
		
		return user;		
	}
}
