package zonaProp.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import zonaProp.model.PersistentEntity;
import zonaProp.model.publication.Publication;
import zonaProp.validators.LengthValidator;
import zonaProp.validators.MailFormatValidator;

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
		new MailFormatValidator("mail").check(email);
		this.email = email;
	}

	private void setPhone(String phone) {
		new LengthValidator("telefono", 3, 40).check(phone);
		this.phone = phone;
	}
	
	public abstract String getCompleteName();
	
	public int getActivePublicationsQuantity() {
		int cant = 0;
		for(Publication p:this.publications) {
			if(p.isActive())
				cant++;
		}
		return cant;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((publications == null) ? 0 : publications.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (publications == null) {
			if (other.publications != null)
				return false;
		} else if (!publications.equals(other.publications))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
