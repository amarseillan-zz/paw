package zonaProp.transfer.bussiness;

import java.security.InvalidParameterException;
import java.util.List;

import zonaProp.services.PublicationService;
import zonaProp.validators.LengthValidator;

public class User {

	private int id;
	private String username;
	private String password;
	private String name;
	private String lastName;
	private String email;
	private String phone;
	
	private List<Publication> publications=null;

	public User(){
		
	}
	
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
	
	public List<Publication> getPublications(){
		if(publications==null){
			PublicationService ps=PublicationService.getInstance();
			publications=ps.getAll(id);
		}
		
		return publications;
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
		new LengthValidator("nombre de usuario", 3, 20).check(username);
		this.username = username;
	}

	public void setPassword(String password) throws InvalidParameterException {
		new LengthValidator("contraseña", 3, 20).check(password);
		this.password = password;
	}

	public void setName(String name) throws InvalidParameterException {
		new LengthValidator("nombre", 3, 20).check(name);
		this.name = name;
	}

	public void setLastName(String lastName) throws InvalidParameterException {		
		new LengthValidator("apellido", 3, 20).check(lastName);
		this.lastName = lastName;
	}

	public void setEmail(String email) throws InvalidParameterException {
		new LengthValidator("mail", 3, 40).check(email);
		this.email = email;
	}

	public void setPhone(String phone) throws InvalidParameterException {
		new LengthValidator("telefono", 3, 15).check(phone);
		this.phone = phone;
	}
	
}
