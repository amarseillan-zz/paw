package zonaProp.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import zonaProp.model.user.User;
import zonaProp.model.user.UserRepo;

@Component
public class LoggedFilter extends OncePerRequestFilter {

	private UserRepo ur;
	
	@Autowired
	public LoggedFilter(UserRepo ur) {
		this.ur = ur;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse resp, FilterChain filterChain)
			throws ServletException, IOException {
		if (req.getSession().getAttribute("userId")==null) {
			System.out.println("LoggedFilter: user==null");
			Cookie[] cs =req.getCookies();
			User u = null;
			if(cs!=null){
				for(Cookie c:cs){
					System.out.println("LoggedFilter: cukis");
					if("userid".equals(c.getName()) && c.getValue()!=null){
						u = ur.get(Integer.valueOf(c.getValue()));
					}
					if("username".equals(c.getName()) && c.getValue()!=null){
						req.setAttribute("username", c.getValue());
					}
				}
				if (u!=null){
					req.getSession().setAttribute("userId",u.getId());
					//This is optional but will be probably useful to redirect to the main page.
					if(req.getRequestURI().contains("login")){ 
						resp.sendRedirect("publications");
						return;
					}
				}
			}
			System.out.println("LoggedFilter: antes de doFilter");
			filterChain.doFilter(req, resp);
		} else {
			System.out.println("LoggedFilter: user!=null");
			if(req.getRequestURI().contains("login")){ 
				resp.sendRedirect("publications");
				return;
			}
			filterChain.doFilter(req, resp);
		}
		
	}

}
