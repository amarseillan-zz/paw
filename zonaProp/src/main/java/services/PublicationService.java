package services;

import java.util.List;

import persistence.PublicationDAO;
import transfer.bussiness.Publication;

public class PublicationService {

	private static PublicationService instance;
	PublicationDAO pDAO;
	
	public static synchronized PublicationService getInstance() {
		if (instance == null) {
			instance = new PublicationService();
		}
		return instance;
	}
	
	private PublicationService(){
		pDAO = new PublicationDAO();
	}
	
	public Publication create(Publication p){
		return pDAO.createPublication(p);
	}
	
	public Publication getPublication(int pid, int userId){
		Publication p = pDAO.getPublication(pid);
		if( p.getUserId() != userId ){
			p = null;
		}
		return p;
	}
	
	public List<Publication> getAll(int userId){
		return pDAO.getAll(userId);
	}
	
	public void update(Publication p){
		pDAO.updatePublication(p);
	}
	
}
