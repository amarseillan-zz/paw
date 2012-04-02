package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.UserService;

public class User extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			int userId = Integer.parseInt(req.getParameter("userId"));
			UserService us = UserService.getInstance();
			req.setAttribute("user", us.getUser(userId));
			req.getRequestDispatcher("/WEB-INF/jsp/userInfo.jsp").forward(req,
					resp);
		} catch (NumberFormatException nfe) {
			resp.sendError(400);
		}
	}
}
