package zonaProp.model.user;

import javax.persistence.Entity;

import zonaProp.validators.LengthValidator;

@Entity
public class PrivatePerson extends User {

	private String name;
	private String lastName;
	
	public PrivatePerson(){
	}
	
	public PrivatePerson(String name, String lastName, String email,
			String phone, String username, String password) {
		super(email, phone, username, password);
		setName(name);
		setLastName(lastName);
	}
	
	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}
	
	private void setName(String name)  {
		new LengthValidator("nombre", 3, 20).check(name);
		this.name = name;
	}

	private void setLastName(String lastName)  {		
		new LengthValidator("apellido", 3, 20).check(lastName);
		this.lastName = lastName;
	}

	@Override
	public String getCompleteName() {
		return name + " " + lastName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrivatePerson other = (PrivatePerson) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
