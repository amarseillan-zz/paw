package transfer.bussiness;

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
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
	public static boolean validParams(String name, String lastName, String email,
			String phone, String username, String password1, String password2) {
		
		if(name.length() < 3 || name.length() > 20)
				return false;
		
		if(lastName.length() < 3 || lastName.length() > 20)
			return false;
		
		if(username.length() < 3 || username.length() > 20)
			return false;
		
		if(email.length() < 3 || email.length() > 40)
			return false;
		
		if(phone.length() < 3 || phone.length() > 15)
			return false;
		
		if(password1.length() < 6 || password1.length() > 20)
			return false;
	
		if(password2.length() < 6 || password2.length() > 20)
			return false;
		
		if(!password1.equals(password2))
			return false;
		
		return true;
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
}
