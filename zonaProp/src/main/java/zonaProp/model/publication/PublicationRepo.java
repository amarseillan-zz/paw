package zonaProp.model.publication;

import java.util.List;

import zonaProp.model.Search;
import zonaProp.model.photo.Photo;




public interface PublicationRepo {

	/**
	 * Obtiene la lista de todas las publicaciones.
	 */
	public List<Publication> getAll();

	/**
	 * Obtiene la publicación con un determinado id.
	 */
	public Publication get(int id);
	
	/**
	 * Almacena una nueva publicación.
	 */
	public void add(Publication user);

	
	/**
	 * 
	 * Devuelve la lista de las publicaciones que cumplan con el criterio @search
	 */
	public List<Publication> getSome(Search search);


	
	/*
	 * Devuelve la Photo con el ID indicado
	 */
	public Photo getPhoto(Integer id);

	public Environment getEnvironment(Integer valueOf);
}
