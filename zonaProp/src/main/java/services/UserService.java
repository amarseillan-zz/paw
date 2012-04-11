package services;


import exceptions.DuplicatedUsernameException;
import exceptions.InvalidParametersException;
import persistence.UserDAO;
import transfer.bussiness.User;
import transfer.forms.UserForm;

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
	
	public User createNewUser(UserForm uf)
			throws DuplicatedUsernameException, InvalidParametersException {
		
		User user = uf.getUser();
		
		if(userAlreadyExist(user)){
			throw new DuplicatedUsernameException();			
		}
		
		user = createUser(user);
		
		if(user.getId() == 0)
			return null;
		
		return user;		
	}
}
