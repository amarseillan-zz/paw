package web;

import java.io.IOException;
import java.security.InvalidParameterException;

import transfer.bussiness.User;

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
		String username = req.getParameter("username");
		String password1 = req.getParameter("password1");
		String password2 = req.getParameter("password2");
		String name = req.getParameter("name");
		String lastName = req.getParameter("lastname");
		String email = req.getParameter("mail");
		String phone = req.getParameter("phone");
		
		UserService us = UserService.getInstance();
		
		try{
		user = us.createNewUser(name, lastName, email, phone, username, password1, password2);		
		}catch(DuplicatedUsernameException due){
			error="este nombre de usuario ya fue utilizado";
		}catch(InvalidParameterException ipe){
			error=ipe.getMessage();
		}
		
		
		if( user != null ){
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("publicationList?userId=" + user.getId());
		} else {
			
			//req.setAttribute("user", new User(0, name, lastName, email,phone, username, ""));
			req.setAttribute("username", username);
			req.setAttribute("name", name);
			req.setAttribute("astName", lastName);
			req.setAttribute("email", email);
			req.setAttribute("phone", phone);
			req.setAttribute("pass1", password1);
			req.setAttribute("pass2", password2);
			req.setAttribute("error", error);
			req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
		}
	}
	


}
