package zonaProp.mailing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zonaProp.transfer.bussiness.Comment;
import zonaProp.transfer.bussiness.User;

@Component
public class MailingService {
	private SendMailTLS sendMailTLS;
	
	@Autowired
	public MailingService(SendMailTLS s) {
		sendMailTLS=s;
	}
	
	public void contact(Comment c, User u){
		
		sendMailTLS.send(c.getEmail(), u.getEmail(), "Coment— en una de tus propiedades "
				+ c.getName(), "mail del comentante: " + c.getEmail() + "\ntel: " + c.getPhone()
				+ "\ncomentario:\n" + c.getComment());

	}
}
