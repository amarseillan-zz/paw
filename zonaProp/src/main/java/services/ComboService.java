package services;

import java.util.List;

import persistence.ComboDAO;
import transfer.forms.Combo;

public class ComboService {

	private static ComboService instance;
	ComboDAO cDAO;
	
	public static synchronized ComboService getInstance() {
		if (instance == null) {
			instance = new ComboService();
		}
		return instance;
	}
	
	private ComboService(){
		cDAO = new ComboDAO();
	}
	
	public List<Combo> getTypes(){
		return cDAO.getTypes();
	}
	
	public List<Combo> getOperationTypes(){
		return cDAO.getOperationTypes();
	}
	
}
