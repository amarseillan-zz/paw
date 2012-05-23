package zonaProp.model.publication;

import zonaProp.validators.LengthValidator;



public class Comment {
	private String name;
	private String email;
	private String phone;
	private String comment;

	public Comment(String name, String email, String phone, String comment) {
		setName(name);
		setEmail(email);
		setPhone(phone);
		setComment(comment);
	}

	private void setName(String name) {
		new LengthValidator("nombre", 3, 20).check(name);
		this.name = name;
	}

	private void setEmail(String email) {
		new LengthValidator("mail", 3, 20).check(email);
		this.email = email;
	}

	private void setPhone(String phone) {
		new LengthValidator("telefono", 3, 20).check(phone);
		this.phone = phone;
	}

	private void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getComment() {
		return comment;
	}
}