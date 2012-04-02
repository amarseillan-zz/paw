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

public class PublicationList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("user");
		PublicationService ps = PublicationService.getInstance();
		List<Publication> pList = ps.getAll(user.getId());
		List<PublicationForm> pfList = new ArrayList<PublicationForm>();
		for( Publication p: pList){
			pfList.add(new PublicationForm(p));
		}
		req.setAttribute("pList", pfList);
		req.getRequestDispatcher("/WEB-INF/jsp/publicationList.jsp").forward(req, resp);
	}

}
