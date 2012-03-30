package persistence;


/**
 * Excepción no chequeada que se lanza cuando ocurre un error fatal en la base de datos.
 */
public class DatabaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7360343368227756163L;

	public DatabaseException(String message, Throwable cause) {
		super(message, cause);
	}
}
