package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.PublicationService;

public class Publication extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			int userId = Integer.parseInt(req.getParameter("userId"));
			int publicationId = Integer.parseInt(req.getParameter("publicationId"));
			PublicationService ps = PublicationService.getInstance();
			req.setAttribute("publication", ps.getPublication(publicationId, userId));
			req.getRequestDispatcher("/WEB-INF/jsp/publication.jsp").forward(req,
					resp);
		} catch (NumberFormatException nfe) {
			resp.sendError(400);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("phone"));
		System.out.println(req.getParameter("email"));
		System.out.println(req.getParameter("comment"));
	}
}