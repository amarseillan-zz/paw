package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.PublicationService;
import transfer.bussiness.Publication;
import transfer.bussiness.User;
import transfer.forms.PublicationForm;

public class PublicationABM extends HttpServlet {

	PublicationService ps = PublicationService.getInstance();
	PublicationForm pf = new PublicationForm();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Publication p;
		
		if( req.getParameter("pid") != null ){
			int publicationId = Integer.valueOf(req.getParameter("pid"));
			p = ps.getPublication(publicationId, ((User)req.getSession().getAttribute("user")).getId());
			pf = new PublicationForm(p);
		}else{
			
		}
		req.setAttribute("publication", pf);
		req.getRequestDispatcher("/WEB-INF/jsp/publicationDetail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

}
