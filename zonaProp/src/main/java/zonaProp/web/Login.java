package zonaProp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import zonaProp.model.repo.UserRepo;
import zonaProp.transfer.bussiness.User;

public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserRepo users;

	@Autowired
	public Login(UserRepo users) {
		this.users = users;
	}

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
		if (users.authenticate(username, password)) {
			User user = users.get(username);
			req.getSession().setAttribute("userId", user.getId());
			if ("on".equals(req.getParameter("remember"))) {
				resp.addCookie(new Cookie("userid",
						String.valueOf(user.getId())));
			}
			if ("on".equals(req.getParameter("rememberu"))) {
				resp.addCookie(new Cookie("username", String.valueOf(username)));
			} else {
				resp.addCookie(new Cookie("username", ""));
			}
			resp.sendRedirect("publicationSearch");
		} else {
			req.setAttribute("username", username);
			req.setAttribute("error",
					"Nombre de usuario o contrase�a inv�lidos");
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,
					resp);
		}
	}

}
