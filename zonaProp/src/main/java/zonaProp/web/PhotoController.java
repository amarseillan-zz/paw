package zonaProp.web;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import zonaProp.model.photo.Photo;

@Controller
public class PhotoController {
	@RequestMapping(method = RequestMethod.GET)
	public void viewPhoto(@RequestParam("imageId") Photo photo,
			HttpServletResponse resp) {
		if (photo == null) {
			return;
		}
		resp.setContentType("image/jpeg");
		resp.setHeader("Content-Disposition", "inline; filename=\"imagen"
				+ photo.getId() + "\"");
		OutputStream output = null;
		try {
			output = resp.getOutputStream();
			resp.setContentLength(photo.getSize());
			output.write(photo.getData());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				output.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
