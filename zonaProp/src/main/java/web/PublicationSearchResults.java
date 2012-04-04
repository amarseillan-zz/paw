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
import transfer.forms.PublicationForm;

public class PublicationSearchResults extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int type = req.getParameter("type") == null || req.getParameter("type").equals("")?-1:Integer.parseInt(req.getParameter("type"));
		int operation_type = req.getParameter("operation_type") == null || req.getParameter("operation_type").equals("")?-1:Integer.parseInt(req.getParameter("operation_type"));
		int maxPrice = req.getParameter("maxPrice") == null || req.getParameter("maxPrice").equals("")?-1:Integer.parseInt(req.getParameter("maxPrice"));
		int minPrice = req.getParameter("minPrice") == null || req.getParameter("minPrice").equals("")?-1:Integer.parseInt(req.getParameter("minPrice"));
		boolean ascending = (req.getParameter("ascending") == null || req.getParameter("ascending").equals(""))?false:req.getParameter("ascending").equals("on");
		PublicationService ps = PublicationService.getInstance();
		List<Publication> pList = ps.advancedSearch(type, operation_type, maxPrice, minPrice,ascending);
		// for testing: publicationSearchResults?type=1&operation_type=1&maxPrice=151000&minPrice=149000
		List<PublicationForm> pfList = new ArrayList<PublicationForm>();
		for( Publication p: pList){
			pfList.add(new PublicationForm(p));
		}
		req.setAttribute("pList", pfList);
		req.getRequestDispatcher("/WEB-INF/jsp/publicationResultsList.jsp").forward(req, resp);
	}

}
