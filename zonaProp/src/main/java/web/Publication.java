package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.PublicationService;
import transfer.forms.VisitForm;
import validators.VisitFormValidator;

public class Publication extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	PublicationService ps = PublicationService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			int publicationId = Integer.parseInt(req.getParameter("publicationId"));
			transfer.bussiness.Publication p = ps.getPublication(publicationId);

			
			req.setAttribute("publication", p);
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
		
		VisitForm vf= new VisitForm(req);
		
		int publicationId = Integer.parseInt(req.getParameter("publicationId"));
		transfer.bussiness.Publication p=ps.getPublication(publicationId);
		

		List<String> errors = new VisitFormValidator().check(vf);
		
		if(errors == null){
			ps.sendMailToPublisher(p, vf);
			req.setAttribute("showPublisher", true);
		}
		else{
			req.setAttribute("showPublisher", false);
			req.setAttribute("vf", vf);
		}
    	

		req.setAttribute("publication", p);
		req.setAttribute("errors", errors);
		
		req.getRequestDispatcher("/WEB-INF/jsp/publication.jsp").forward(req,
				resp);
	}
}