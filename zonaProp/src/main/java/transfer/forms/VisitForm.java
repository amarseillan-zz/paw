package transfer.forms;

import java.security.InvalidParameterException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import mailing.SendMailTLS;
import transfer.bussiness.User;

public class VisitForm {

	HttpServletRequest req;

	public VisitForm(HttpServletRequest req) {
		this.req = req;
	}

	public void sendMailTo(User to) throws InvalidParameterException {

		String name = req.getParameter("name");

		if (name.length() < 3 || name.length() > 20)
			throw new InvalidParameterException(
					"El nombre debe tener entre 3 y 20 caracters.");

		String email = req.getParameter("email");
		if (email.length() < 3 || email.length() > 40)
			throw new InvalidParameterException(
					"El mail debe tener entre 3 y 40 carecteres.");

		String phone = req.getParameter("phone");
		if (phone.length() < 3 || phone.length() > 15)
			throw new InvalidParameterException(
					"El telefono debe tener entre 3 y 15 caracteres.");

		Properties p = SendMailTLS.getMailProperties("");
		SendMailTLS sender = new SendMailTLS(p);
		sender.send(req.getParameter("email"), to.getEmail(),
				"Comentó en una de tus propiedades " + req.getParameter("name"),
				"mail del comentante:" + req.getParameter("email") + "\ntel:"
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
