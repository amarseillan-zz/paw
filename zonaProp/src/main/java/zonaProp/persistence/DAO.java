package zonaProp.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class DAO {
	private static String driver;
	private static String connectionString;
	private static String username;
	private static String password;
	static ConnectionManager manager;

	public DAO() {
		Properties file = new Properties();
		InputStream MyInputStream = null;
		MyInputStream = this.getClass().getClassLoader()
				.getResourceAsStream("db.properties");
		try {
			file.load(MyInputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		driver = file.getProperty("DRIVER");
		connectionString = file.getProperty("CONNECTION");
		username = file.getProperty("USER");
		password = file.getProperty("PASS");

		manager = new ConnectionManager(driver, connectionString, username,
				password);

	}
}
