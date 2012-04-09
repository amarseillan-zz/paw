package web;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import services.PhotoService;
import services.PublicationService;
import transfer.bussiness.Photo;
import transfer.bussiness.Publication;

public class PhotoUpload extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static PublicationService ps = PublicationService.getInstance();
	
	private static Publication p;
	
	private static List<Photo> photos = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		if (req.getParameter("pid") != null) {
			int publicationId = Integer.valueOf(req.getParameter("pid"));
			p = ps.getPublication(publicationId);
				
			PhotoService ps = PhotoService.getInstance(); 
	       	photos = ps.getPhotosByPublicationId(p.getPublicationId());
	       	
			req.setAttribute("photos", photos);
			req.setAttribute("pid", p.getPublicationId());
			req.getRequestDispatcher("/WEB-INF/jsp/photoUpload.jsp").forward(req, resp);
		
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String errors = "";		
		FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
                @SuppressWarnings("unchecked")
				List<FileItem> fields = upload.parseRequest(req);
                Iterator<FileItem> it = fields.iterator();
                while (it.hasNext()) {
                		Photo image = null;
                        FileItem fileItem = it.next();     
                    	PhotoService ps = PhotoService.getInstance(); 
                    	try{
                    		image = ps.createPhotoFromFileItem(fileItem, p.getPublicationId());	     
                    		if(image != null){
	                        	ps.uploadPhoto(image);   
	                        	errors = " Imagen subida con exito.";
                    		}
                		}catch(InvalidParameterException ipe){
                			errors=ipe.getMessage();
                		}catch(IOException e){                			
                		}	                                         
                }
        } catch (FileUploadException e) {
                e.printStackTrace();
        }
        
        PhotoService ps = PhotoService.getInstance(); 
       	photos = ps.getPhotosByPublicationId(p.getPublicationId());       	
		req.setAttribute("photos", photos);
		req.setAttribute("pid", p.getPublicationId());
		req.setAttribute("error", errors);
		req.getRequestDispatcher("/WEB-INF/jsp/photoUpload.jsp").forward(req, resp);
		
	}

}
