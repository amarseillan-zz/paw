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
import transfer.bussiness.User;

public class PhotoDeleter extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static PublicationService ps = PublicationService.getInstance();
	
	private static Publication p;
	
	private static List<Photo> photos = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		if (req.getParameter("pid") != null && req.getParameter("imageId") != null) {
			int publicationId = Integer.valueOf(req.getParameter("pid"));
			int imageId = Integer.valueOf(req.getParameter("imageId"));
			p = ps.getPublication(publicationId);
			if(p.getUserId()==((User) req.getSession().getAttribute("user")).getId()){
				
				PhotoService ps = PhotoService.getInstance(); 
				ps.deletePhotoById(imageId);
				
		       	photos = ps.getPhotosByPublicationId(p.getPublicationId());		       	
				req.setAttribute("photos", photos);
				req.setAttribute("pid", p.getPublicationId());
				req.getRequestDispatcher("/WEB-INF/jsp/photoUpload.jsp").forward(req, resp);
			}
		}
	}

}
