package transfer.bussiness;

import java.security.InvalidParameterException;

public class User {

	private int id;
	private String username;
	private String password;
	private String name;
	private String lastName;
	private String email;
	private String phone;

	public User(int id, String name, String lastName, String email,
			String phone, String username, String password) {
		super();
		this.id = id;
		setUsername(username);
		setPassword(password);
		setName(name);
		setLastName(lastName);
		setEmail(email);
		setPhone(phone);
	}
	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) throws InvalidParameterException {
		if(username.length() < 3 || username.length() > 20)
			throw new InvalidParameterException("nombre de usuario muy largo o muy corto.");
		this.username = username;
	}

	public void setPassword(String password) throws InvalidParameterException {
		if(password.length() < 3 || password.length() > 20)
			throw new InvalidParameterException("contraseña muy larga o muy corta.");
		this.password = password;
	}

	public void setName(String name) throws InvalidParameterException {
		if(name.length() < 3 || name.length() > 20)
			throw new InvalidParameterException("nombre muy largo o muy corto.");
		this.name = name;
	}

	public void setLastName(String lastName) throws InvalidParameterException {		
		if(lastName.length() < 3 || lastName.length() > 20)
			throw new InvalidParameterException("apellido de usuario muy largo o muy corto.");
		this.lastName = lastName;
	}

	public void setEmail(String email) throws InvalidParameterException {
		if(email.length() < 3 || email.length() > 40)
			throw new InvalidParameterException("mail muy largo o muy corto.");
		this.email = email;
	}

	public void setPhone(String phone) throws InvalidParameterException {
		if(phone.length() < 3 || phone.length() > 15)
			throw new InvalidParameterException("telefono muy largo o muy corto.");
		this.phone = phone;
	}
}
