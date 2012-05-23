package zonaProp.web.command;

import zonaProp.model.publication.Comment;


public class CommentForm {
	private String name;
	private String email;
	private String phone;
	private String comment;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Comment build() {
		return new Comment(name,email,phone,comment);
	}

}
