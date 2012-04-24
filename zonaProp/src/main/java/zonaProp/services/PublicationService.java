package zonaProp.services;

import java.util.ArrayList;
import java.util.List;

import zonaProp.persistence.PublicationDAO;
import zonaProp.transfer.bussiness.Publication;
import zonaProp.transfer.bussiness.User;
import zonaProp.transfer.bussiness.Comment;

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
	
	public void save(Publication p, int userId){
		pDAO.save(p, userId);
		return;
	}
	
	public Publication getPublication(int pid){
		Publication p = pDAO.getPublication(pid);
		return p;
	}
	
	public List<Publication> getAll(int userId){
		return pDAO.getAll(userId);
	}
	
	
	public List<Publication> advancedSearch(int type, int operation_type, int maxPrice, int minPrice, boolean ascending){
		List<Publication> aux = pDAO.advancedSearch(type, operation_type, maxPrice, minPrice, ascending);
		List<Publication> pList = new ArrayList<Publication>();
		for( Publication p: aux ){
			if( p.isActive() ){
				pList.add(p);
			}
		}
		return pList;
	}
	
	
	public void sendMailToPublisher(Publication p, Comment visit){
		User publisher=p.getPublisher();
		visit.sendMailTo(publisher);
	}
	
}
