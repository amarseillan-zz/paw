package zonaProp.model.mailing;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class SendMailTLS {
	private ExecutorService es = Executors.newFixedThreadPool(5);
	private String username;
	private String password;
	private String auth;
	private String enable;
	private String host;
	private String port;
	
	@Autowired
	public SendMailTLS(@Value("${mail.username}")String username, @Value("${mail.password}")String password, @Value("${mail.smtp.auth}")String auth,
			@Value("${mail.smtp.starttls.enable}")String enable, @Value("${mail.smtp.host}")String host, @Value("${mail.smtp.port}")String port) {
		this.username = username;
		this.password = password;
		this.auth = auth;
		this.enable = enable;
		this.host = host;
		this.port = port;
	}

	public void send(final String from, final String to, final String subject,
			final String text) {
		Properties p = new Properties();
		p.setProperty("mail.smtp.auth", auth);
		p.setProperty("mail.smtp.starttls.enable", enable);
		p.setProperty("mail.smtp.host", host);
		p.setProperty("mail.smtp.port", port);
		p.setProperty("username", username);
		p.setProperty("password", password);
		System.out.println(auth + enable + host + port + username + password);
		final Session session = Session.getInstance(p,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		try {
			es.execute(new Runnable() {

				public void run() {
					try {

						Message message = new MimeMessage(session);
						message.setFrom(new InternetAddress(from));
						message.setRecipients(Message.RecipientType.TO,
								InternetAddress.parse(to));
						message.setSubject(subject);
						message.setText(text);

						Transport.send(message);

					} catch (MessagingException e) {
						throw new RuntimeException(e);
					}
				}
			});
		} catch (Exception e) {
			System.out.println("Executor has been closed already.");
		}

	}

	public void Stop() {
		es.shutdown();
	}
	public static void test() {
//		SendMailTLS sender = new SendMailTLS("mail.properties");
//		sender.send("maximo@maxsoft.com", "maximovs@gmail.com", "1",
//				"hola hola");
//		sender.Stop();

	}
}
