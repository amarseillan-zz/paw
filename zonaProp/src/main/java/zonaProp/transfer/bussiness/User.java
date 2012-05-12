package zonaProp.transfer.bussiness;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import zonaProp.validators.LengthValidator;

@Entity
@Table(name="sys_user")
public class User extends PersistentEntity{

	private String username;
	private String password;
	private String name;
	private String lastName;
	private String email;
	private String phone;
	
	@OneToMany(mappedBy="publisher")
	private List<Publication> publications= new ArrayList<Publication>();

	public User(){
		super(0);
	}
	
	public User(int id, String name, String lastName, String email,
			String phone, String username, String password) {
		super(id);
		setUsername(username);
		setName(name);
		setLastName(lastName);
		setEmail(email);
		setPhone(phone);
		setPassword(password);
	}
	
	public List<Publication> getPublications(){
		return publications;
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

	public void setUsername(String username)  {
		new LengthValidator("nombre de usuario", 3, 20).check(username);
		this.username = username;
	}

	public void setPassword(String password)  {
		new LengthValidator("contraseña", 3, 20).check(password);
		this.password = password;
	}

	public void setName(String name)  {
		new LengthValidator("nombre", 3, 20).check(name);
		this.name = name;
	}

	public void setLastName(String lastName)  {		
		new LengthValidator("apellido", 3, 20).check(lastName);
		this.lastName = lastName;
	}

	public void setEmail(String email)  {
		new LengthValidator("mail", 3, 40).check(email);
		this.email = email;
	}

	public void setPhone(String phone)  {
		new LengthValidator("telefono", 3, 15).check(phone);
		this.phone = phone;
	}
	
}
