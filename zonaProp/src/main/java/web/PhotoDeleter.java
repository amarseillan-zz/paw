package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import services.PhotoService;
import services.PublicationService;
import transfer.bussiness.Photo;
import transfer.bussiness.Publication;

public class PhotoDeleter extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		
		if (req.getParameter("pid") != null && req.getParameter("imageId") != null) {
			int publicationId = Integer.valueOf(req.getParameter("pid"));
			int imageId = Integer.valueOf(req.getParameter("imageId"));
			
			PublicationService ps = PublicationService.getInstance();
			Publication p = ps.getPublication(publicationId);
			
			if(p.getUserId() != (Integer)req.getSession().getAttribute("userId")) {
		           resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		           return;
		    }

			PhotoService photoS = PhotoService.getInstance(); 
			photoS.deletePhotoById(imageId);
			
			List<Photo> photos = photoS.getPhotosByPublicationId(p.getPublicationId());		       	
			req.setAttribute("photos", photos);
			req.setAttribute("pid", p.getPublicationId());
			req.getRequestDispatcher("/WEB-INF/jsp/photoUpload.jsp").forward(req, resp);
			
		}
	}

}
