package zonaProp.transfer.bussiness;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import zonaProp.validators.LengthValidator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "sys_user")
public abstract class User extends PersistentEntity {

	private String username;
	private String password;
	private String email;
	private String phone;

	@OneToMany(mappedBy = "publisher")
	private List<Publication> publications = new ArrayList<Publication>();

	public User(){
	}
	
	public User(String email, String phone, String username,
			String password) {
		super();
		setUsername(username);
		setEmail(email);
		setPhone(phone);
		setPassword(password);
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void addPublication(Publication publication) {
		publications.add(publication);
		if (!publication.getPublisher().equals(this)) {
			publication.setPublisher(this);
		}
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

	private void setUsername(String username) {
		new LengthValidator("nombre de usuario", 3, 20).check(username);
		this.username = username;
	}

	private void setPassword(String password) {
		new LengthValidator("contraseña", 3, 20).check(password);
		this.password = password;
	}

	private void setEmail(String email) {
		new LengthValidator("mail", 3, 40).check(email);
		this.email = email;
	}

	private void setPhone(String phone) {
		new LengthValidator("telefono", 3, 40).check(phone);
		this.phone = phone;
	}
	
	public abstract String getCompleteName();

}
