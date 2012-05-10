package zonaProp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import zonaProp.model.repo.DuplicatedUserException;
import zonaProp.model.repo.UserRepo;
import zonaProp.transfer.bussiness.User;
import zonaProp.transfer.forms.UserForm;
import zonaProp.validators.UserFormValidator;


public class SignUp extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserRepo users;

	
	@Autowired
	public SignUp(UserRepo users) {
		this.users = users;
	}
	
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

		
		
		List<String> errors = new UserFormValidator().check(uf);
		
		if( errors == null ){
			user = uf.getUser();
			try {
				users.add(user);
				req.getSession().setAttribute("userId", user.getId());
				resp.sendRedirect("publicationSearch");
			} catch (DuplicatedUserException e) {
				//TODO manejar el error de duplicados
			}
		} else {

			req.setAttribute("errors", errors);
			req.setAttribute("uf", uf);
			req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
		}
	}
	


}
