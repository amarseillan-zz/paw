package persistence;

public abstract class DAO {
	private static final String driver = "org.postgresql.Driver";
	private static final String connectionString = "jdbc:postgresql://localhost/paw3";
	private static final String username = "paw";
	private static final String password = "paw";
	static final ConnectionManager manager = new ConnectionManager(driver, connectionString, username, password);
	
	public DAO() {
	}
}
