package zonaProp.transfer.bussiness;

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
		return name + lastName;
	}
}
