package zonaProp.model.repo;

import java.util.List;

import zonaProp.transfer.bussiness.RealEstate;
import zonaProp.transfer.bussiness.User;

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
