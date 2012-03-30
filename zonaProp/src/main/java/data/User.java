package data;

public class User {

	private String name;
	private String lastName;
	private String email;
	private String number;
	private String username;
	private String password;
	//	nombre, apellido, email, teléfono, usuario y contraseña
	public User() {
		// Default constructor for JavaBeans.
	}
	public User(String name, String lastName, String email, String number,
			String username, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.number = number;
		this.username = username;
		this.password = password;
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
	public String getNumber() {
		return number;
	}
	public String getUsername() {
		return username;
	}


}
