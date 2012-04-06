package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.UserService;
import transfer.forms.PublicationForm;
import transfer.bussiness.Publication;
import transfer.bussiness.User;

public class PublicationList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			UserService us= UserService.getInstance();
			User user = us.getUser((Integer)req.getSession().getAttribute("userId"));
			if(user==null){
				resp.sendRedirect("login");
			}else
			{
				
				List<Publication> pList= user.getPublications();
				List<PublicationForm> pfList = new ArrayList<PublicationForm>();
				
				for( Publication p: pList){
					pfList.add(new PublicationForm(p));
				}
				
				req.setAttribute("pList", pfList);
				req.getRequestDispatcher("/WEB-INF/jsp/publicationList.jsp")
						.forward(req, resp);
			}
		} catch (NumberFormatException nfe) {
			resp.sendError(400);
		}
	}

}
