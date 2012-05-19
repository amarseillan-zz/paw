package zonaProp.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class RestrictedFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse resp, FilterChain filterChain)
					throws ServletException, IOException {
		System.out.println(req.getContextPath());
		System.out.println(req.getRequestURI());
		if(req.getRequestURI().matches(".*/bin.*") || req.getRequestURI().matches(".*/css.*") || req.getRequestURI().matches(".*/imgs.*")){
			filterChain.doFilter(req, resp);
		}else{
				resp.sendRedirect("/zonaProp/bin/publication/search");
		}
	}

}
