package mailing;

import java.io.IOException;
import java.io.InputStream;
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

public class SendMailTLS {
	private static ExecutorService es = Executors.newFixedThreadPool(5);
	private static Properties p;

	public static void test() {
		Properties p = SendMailTLS.getMailProperties("");
		SendMailTLS sender = new SendMailTLS(p);
		sender.send("maximo@maxsoft.com", "maximovs@gmail.com", "1",
				"Si viste?");
		sender.send("maximo@maxsoft.com", "maximovs@gmail.com", "2",
				"Si viste?");
		sender.send("maximo@maxsoft.com", "maximovs@gmail.com", "3",
				"Si viste?");
		sender.Stop();

	}

	public static Properties getMailProperties(String path) {
		if (p != null) {
			return p;
		}
		Properties props = new Properties();
		InputStream input = null;
		try {
			// If possible, one should try to avoid hard-coding a path in this
			// manner; in a web application, one should place such a file in
			// WEB-INF, and access it using ServletContext.getResourceAsStream.
			// This file contains the javax.mail config properties mentioned
			// above.
			input = ClassLoader.getSystemResourceAsStream("mail.properties");
			props.load(input);
		} catch (IOException ex) {
			System.err
					.println("Cannot open and load mail server properties file.");
		} finally {
			try {
				if (input != null)
					input.close();
			} catch (IOException ex) {
				System.err.println("Cannot close mail server properties file.");
			}
		}

		return props;
	}

	public SendMailTLS(Properties p) {
		this.p = p;
	}

	public void send(final String from, final String to, final String subject,
			final String text) {

		final String username = p.getProperty("username");
		final String password = p.getProperty("password");
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

						System.out.println("Done");

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
}
