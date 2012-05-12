package zonaProp.model.repo;

import java.util.List;

import zonaProp.transfer.bussiness.User;

public interface UserRepo {

	/**
	 * Obtiene la lista de todos los alumnos.
	 */
	public List<User> getAll();

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
