package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.PublicationService;
import services.UserService;

public class Publication extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			int publicationId = Integer.parseInt(req.getParameter("publicationId"));
			PublicationService ps = PublicationService.getInstance();
			req.setAttribute("publication", ps.getPublication(publicationId));
			req.getRequestDispatcher("/WEB-INF/jsp/publication.jsp").forward(req,
					resp);
		} catch (NumberFormatException nfe) {
			resp.sendError(400);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		int publicationId = Integer.parseInt(req.getParameter("publicationId"));
		PublicationService ps = PublicationService.getInstance();
		req.setAttribute("publication", ps.getPublication(publicationId));
		
		int userId = ps.getPublication(publicationId).getUserId();
		UserService us = UserService.getInstance();
		req.setAttribute("user", us.getUser(userId));
		
		
		req.getRequestDispatcher("/WEB-INF/jsp/publication.jsp").forward(req,
				resp);
	}
}