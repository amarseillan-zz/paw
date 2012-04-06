package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getSession().setAttribute("userId", null);
		req.getSession().invalidate();
		Cookie c = new Cookie("userid", null);
		c.setMaxAge(0);
		resp.addCookie(c);
		resp.sendRedirect("login");
	}
}
