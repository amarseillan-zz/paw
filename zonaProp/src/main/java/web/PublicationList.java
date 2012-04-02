package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.PublicationService;
import transfer.forms.PublicationForm;

public class PublicationList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			int userId = Integer.parseInt(req.getParameter("userId"));
			PublicationService ps = PublicationService.getInstance();
			List<PublicationForm> pfList = ps.getAllAsPublicationForms(userId);
			req.setAttribute("pList", pfList);
			req.getRequestDispatcher("/WEB-INF/jsp/publicationList.jsp")
					.forward(req, resp);
		} catch (NumberFormatException nfe) {
			resp.sendError(400);
		}
	}

}
