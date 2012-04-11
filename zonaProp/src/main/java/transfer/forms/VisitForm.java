package transfer.forms;

import java.security.InvalidParameterException;

import javax.servlet.http.HttpServletRequest;

import mailing.SendMailTLS;
import transfer.bussiness.User;

public class VisitForm {

	HttpServletRequest req;

	public VisitForm(HttpServletRequest req) {
		this.req = req;
	}

	public void sendMailTo(User to) throws InvalidParameterException {
		
		SendMailTLS sender = new SendMailTLS("mail.properties");
		sender.send(req.getParameter("email"), to.getEmail(),
				"Comentó en una de tus propiedades " + req.getParameter("name"),
				"mail del comentante: " + req.getParameter("email") + "\ntel: "
						+ req.getParameter("phone") + "\ncomentario:\n"
						+ req.getParameter("comment"));

	}

	public String getName() {
		return req.getParameter("name");
	}

	public String getEmail() {
		return req.getParameter("email");
	}

	public String getPhone() {
		return req.getParameter("phone");
	}

	public String getComment() {
		return req.getParameter("comment");
	}

}
