package web;

import java.io.IOException;

import transfer.bussiness.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.UserService;

public class SignUp extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String error = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		User user = null;				
		String username = req.getParameter("username");
		String password1 = req.getParameter("password1");
		String password2 = req.getParameter("password2");
		String name = req.getParameter("name");
		String lastName = req.getParameter("lastname");
		String email = req.getParameter("mail");
		String phone = req.getParameter("phone");
		
		user = createNewUser(name, lastName, email, phone, username, password1, password2);		
		
		if( user != null ){
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("publicationList?userId=" + user.getId());
		} else {
			
			req.setAttribute("user", new User(0, name, lastName, email,phone, username, ""));
			req.setAttribute("error", error);
			req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
		}
	}
	
	private User createNewUser(String name, String lastName, String email,
			String phone, String username, String password1, String password2) {
		
		if(!User.validParams(name, lastName, email, phone, username, password1, password2)){
			error = "Datos ingresados incorrectos.";
			return null;
		}
		
		User user = new User(0, name, lastName, email, phone, username, password1);	
		
		UserService us = UserService.getInstance();
		
		if(us.userAlreadyExist(user)){
			error = "Ya existe un usuario con ese nombre.";
			return null;				
		}
		
		user = us.createUser(user);
		
		if(user.getId() == 0)
			return null;
		
		return user;		
	}

}
