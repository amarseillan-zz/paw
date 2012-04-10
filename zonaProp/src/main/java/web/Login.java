package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.UserService;
import transfer.bussiness.User;

public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService us = UserService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = us.authenticate(username, password);
		if( user != null ){
			req.getSession().setAttribute("userId", user.getId());
			if("on".equals(req.getParameter("remember"))){
				resp.addCookie(new Cookie("userid", String.valueOf(user.getId())));
			}
			resp.sendRedirect("publicationSearch");
		} else {
			req.setAttribute("username", username);
			req.setAttribute("error", "Nombre de usuario o contrase�a inv�lidos");
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		}
	}

}
