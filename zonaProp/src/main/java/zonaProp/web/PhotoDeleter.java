package zonaProp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import zonaProp.model.repo.PublicationRepo;
import zonaProp.transfer.bussiness.Photo;
import zonaProp.transfer.bussiness.Publication;

public class PhotoDeleter extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PublicationRepo publications;
	
	@Autowired
	public PhotoDeleter(PublicationRepo publications) {
		this.publications = publications;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		
		if (req.getParameter("pid") != null && req.getParameter("imageId") != null) {
			int publicationId = Integer.valueOf(req.getParameter("pid"));
			int imageId = Integer.valueOf(req.getParameter("imageId"));
			
			Publication p = publications.get(publicationId);
			
			if(p.getPublisher().getId() != (Integer)req.getSession().getAttribute("userId")) {
		           resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		           return;
		    }

			Photo photo = p.getPhotoById(imageId);
			p.deletePhoto(photo);
			
			List<Photo> photos = p.getPhotos();	       	
			req.setAttribute("photos", photos);
			req.setAttribute("pid", p.getId());
			req.getRequestDispatcher("/WEB-INF/jsp/photoUpload.jsp").forward(req, resp);
			
		}
	}

}
