package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.PublicationService;
import transfer.bussiness.Publication;
import transfer.bussiness.User;
import transfer.forms.PublicationForm;

public class PublicationSearchResults extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("user");
		int type = (Integer) (req.getAttribute("type") == null?-1:req.getAttribute("type"));
		int operation_type = (Integer) (req.getAttribute("operation_type") == null?-1:req.getAttribute("operation_type"));
		int maxPrice = (Integer) (req.getAttribute("maxPrice") == null?-1:req.getAttribute("maxPrice"));
		int minPrice = (Integer) (req.getAttribute("minPrice") == null?-1:req.getAttribute("minPrice"));
		PublicationService ps = PublicationService.getInstance();
		List<Publication> pList = ps.advancedSearch(type, operation_type, maxPrice, minPrice);
		List<PublicationForm> pfList = new ArrayList<PublicationForm>();
		for( Publication p: pList){
			pfList.add(new PublicationForm(p));
		}
		req.setAttribute("pList", pfList);
		req.getRequestDispatcher("/WEB-INF/jsp/publicationResultsList.jsp").forward(req, resp);
	}

}
