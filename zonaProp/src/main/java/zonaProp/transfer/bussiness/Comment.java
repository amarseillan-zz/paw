package zonaProp.transfer.bussiness;

import java.security.InvalidParameterException;

import zonaProp.mailing.SendMailTLS;


public class Comment {
	private String name;
	private String email;
	private String phone;
	private String comment;

	public Comment(String name, String email, String phone, String comment) {
		this.name = name;
		this.email = email;
		this.phone = phone;
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