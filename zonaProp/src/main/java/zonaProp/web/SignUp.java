package zonaProp.web;

import java.io.IOException;
import java.util.List;

import zonaProp.services.UserService;
import zonaProp.transfer.bussiness.User;
import zonaProp.transfer.forms.UserForm;
import zonaProp.validators.UserFormValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignUp extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		User user = null;
		UserForm uf = new UserForm(req);

		
		UserService us = UserService.getInstance();
		
		List<String> errors = new UserFormValidator().check(uf);
		
		if( errors == null ){
			user = uf.getUser();
			user = us.createNewUser(user);
			req.getSession().setAttribute("userId", user.getId());
			resp.sendRedirect("publicationSearch");
		} else {

			req.setAttribute("errors", errors);
			req.setAttribute("uf", uf);
			req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
		}
	}
	


}
