package zonaProp.model.user;

import java.util.List;


public interface UserRepo {

	/**
	 * Obtiene la lista de todos los usuarios.
	 */
	public List<User> getAll();
	
	/**
	 * Obtiene la lista de todas las inmobiliarias.
	 */
	public List<RealEstate> getRealStates();

	/**
	 * Obtiene el usuario con un determinado id.
	 */
	public User get(int id);
	
	/**
	 * Almacena un nuevo usuario.
	 */
	public void add(User user) throws DuplicatedUserException;

	public boolean authenticate(String username, String password);

	public User get(String username);
}
