package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ComboService;
import transfer.forms.Combo;

public class PublicationSearch extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ComboService cs = ComboService.getInstance();
		List<Combo> typeList = cs.getTypes();
		List<Combo> oTypeList = cs.getOperationTypes();

		req.setAttribute("typeList", typeList);
		req.setAttribute("oTypeList", oTypeList);
		req.getRequestDispatcher("/WEB-INF/jsp/publicationSearch.jsp").forward(req, resp);
		
	
	}

}
