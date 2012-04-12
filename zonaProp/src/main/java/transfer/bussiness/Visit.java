package transfer.bussiness;

import java.security.InvalidParameterException;

import mailing.SendMailTLS;

public class Visit {
	String name;
	String email;
	String phone;
	String comment;

	public Visit(String name, String email, String phone, String comment) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.comment = comment;
	}

	public void sendMailTo(User to) throws InvalidParameterException {

		SendMailTLS sender = new SendMailTLS("mail.properties");
		sender.send(email, to.getEmail(), "Comentó en una de tus propiedades "
				+ name, "mail del comentante: " + email + "\ntel: " + phone
				+ "\ncomentario:\n" + comment);

	}
}