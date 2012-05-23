package zonaProp.web.command;


import zonaProp.model.user.User;
import zonaProp.model.user.UserRepo;




public class LoginUserForm {
	private String username;
	private String password;
	private String rememberu;
	private String remember;
	
	public LoginUserForm(){
	}

	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRememberu() {
		return rememberu;
	}


	public void setRememberu(String rememberu) {
		this.rememberu = rememberu;
	}


	public String getRemember() {
		return remember;
	}


	public void setRemember(String remember) {
		this.remember = remember;
	}
	
	public User build(UserRepo users){
		if(users.authenticate(username, password)){
			return users.get(username);
		}
		return null;
	}

	
}
