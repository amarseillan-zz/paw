package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		transfer.bussiness.User user = null;				
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
			resp.sendRedirect("publicationList");
		} else {
			req.setAttribute("username", username);
			req.setAttribute("name", name);
			req.setAttribute("lastname", lastName);
			req.setAttribute("mail", email);
			req.setAttribute("phone", phone);
			req.setAttribute("error", "Datos ingresados incorrectos");
			req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
		}
	}
	
	private transfer.bussiness.User createNewUser(String name, String lastName, String email,
			String phone, String username, String password1, String password2) {
		
		if(!transfer.bussiness.User.validParams(name, lastName, email, phone, username, password1, password2))
			return null;
		
		transfer.bussiness.User user = new transfer.bussiness.User(0, name, lastName, email, phone, username, password1);	
		
		UserService us = UserService.getInstance();
		
		if(us.userAlreadyExist(user))
			return null;					
		
		user = us.createUser(user);
		
		if(user.getId() == 0)
			return null;
		
		return user;		
	}

}
