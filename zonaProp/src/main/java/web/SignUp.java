package web;

import java.io.IOException;
import java.security.InvalidParameterException;

import transfer.bussiness.User;
import transfer.forms.UserForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.DuplicatedUsernameException;

import services.UserService;

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
		String error="";
		
		User user = null;
		UserForm uf = new UserForm(req);

		
		UserService us = UserService.getInstance();
		
		try{
		user = us.createNewUser(uf);		
		}catch(DuplicatedUsernameException due){
			error="este nombre de usuario ya fue utilizado";
		}catch(InvalidParameterException ipe){
			error=ipe.getMessage();
		}
		
		
		if( user != null ){
			req.getSession().setAttribute("userId", user.getId());
			resp.sendRedirect("publicationSearch");
		} else {

			req.setAttribute("error", error);
			req.setAttribute("uf", uf);
			req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
		}
	}
	


}
