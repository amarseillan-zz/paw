package web;

import java.io.IOException;
import java.security.InvalidParameterException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.PublicationService;
import transfer.forms.VisitForm;

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
			req.setAttribute("showPublisher", false);
			req.getRequestDispatcher("/WEB-INF/jsp/publication.jsp").forward(req,
					resp);
		} catch (NumberFormatException nfe) {
			resp.sendError(400);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		String error="";
		
		VisitForm vf= new VisitForm(req);
		
		int publicationId = Integer.parseInt(req.getParameter("publicationId"));
		PublicationService ps = PublicationService.getInstance();
		transfer.bussiness.Publication p=ps.getPublication(publicationId);
		
		try{
		ps.sendMailToPublisher(p, vf);
		req.setAttribute("showPublisher", true);
		}catch(InvalidParameterException ipe){
			error=ipe.getMessage();
			req.setAttribute("showPublisher", false);
			req.setAttribute("vf", vf);
		}

		req.setAttribute("publication", p);
		req.setAttribute("error", error);
		
		req.getRequestDispatcher("/WEB-INF/jsp/publication.jsp").forward(req,
				resp);
	}
}