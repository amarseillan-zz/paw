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
		setName(name);
		setLastName(lastName);
		setEmail(email);
		setPhone(phone);
		setPassword(password);
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
			throw new InvalidParameterException("El nombre de usuario debe tener entre 3 y 20 caracteres.");
		this.username = username;
	}

	public void setPassword(String password) throws InvalidParameterException {
		if(password.length() < 3 || password.length() > 20)
			throw new InvalidParameterException("La conteraseña debe tener entre 3 y 20 caracteres.");
		this.password = password;
	}

	public void setName(String name) throws InvalidParameterException {
		if(name.length() < 3 || name.length() > 20)
			throw new InvalidParameterException("El nombre debe tener entre 3 y 20 caracteres.");
		this.name = name;
	}

	public void setLastName(String lastName) throws InvalidParameterException {		
		if(lastName.length() < 3 || lastName.length() > 20)
			throw new InvalidParameterException("El apellido de usuario debe tener entre 3 y 20 caracters.");
		this.lastName = lastName;
	}

	public void setEmail(String email) throws InvalidParameterException {
		if(email.length() < 3 || email.length() > 40)
			throw new InvalidParameterException("El mail debe tener entre 3 y 40 carecteres.");
		this.email = email;
	}

	public void setPhone(String phone) throws InvalidParameterException {
		if(phone.length() < 3 || phone.length() > 15)
			throw new InvalidParameterException("El telefono debe tener entre 3 y 15 caracteres.");
		this.phone = phone;
	}
}
