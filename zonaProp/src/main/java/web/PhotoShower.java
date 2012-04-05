package web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.PhotoService;
import transfer.bussiness.Photo;

public class PhotoShower extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
    
    	Integer imageId = Integer.valueOf(req.getParameter("imageId"));

        if (imageId == null) {
           resp.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }
        
    	PhotoService ps = PhotoService.getInstance(); 
       	Photo image = ps.getPhotoById(imageId);

        if (image == null) {
        	System.out.println("No se ecneuntra la imagen");
            resp.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }

        resp.reset();
        resp.setBufferSize(DEFAULT_BUFFER_SIZE);
        resp.setContentType("image/jpeg"); 
        resp.setHeader("cache-control", "no-cache");
        resp.setHeader("Content-Length", String.valueOf(image.getSize()));
        resp.setHeader("Content-Disposition", "inline; filename=\"imagen\"");

        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            input = new BufferedInputStream(image.getInputStream(), DEFAULT_BUFFER_SIZE);
            output = new BufferedOutputStream(resp.getOutputStream(), DEFAULT_BUFFER_SIZE);

            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } finally {
            close(output);
            close(input);
        }
    }

   private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                // Do your thing with the exception. Print it, log it or mail it.
                e.printStackTrace();
            }
        }
    }

}
