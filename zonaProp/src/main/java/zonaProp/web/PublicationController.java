package zonaProp.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import zonaProp.model.repo.PublicationRepo;
import zonaProp.transfer.bussiness.Photo;
import zonaProp.transfer.bussiness.Publication;
import zonaProp.web.command.CommentForm;
import zonaProp.web.command.PublicationForm;
import zonaProp.web.command.SearchForm;
import zonaProp.web.command.validator.CommentFormValidator;
import zonaProp.web.command.validator.PublicationFormValidator;
import zonaProp.web.command.validator.SearchFormValidator;

@Controller
@SessionAttributes("userId")
public class PublicationController {

	PublicationFormValidator pfv;
	CommentFormValidator cfv;
	SearchFormValidator sfv;
	PublicationRepo publications;

	@Autowired
	public PublicationController(PublicationFormValidator pfv,
			CommentFormValidator cfv, SearchFormValidator sfv,
			PublicationRepo publications) {

		this.pfv = pfv;
		this.sfv = sfv;
		this.cfv = cfv;
		this.publications = publications;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView search() {

		ModelAndView mav = new ModelAndView();
		mav.addObject("searchForm", new SearchForm());
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView searchResults(SearchForm sf, Errors errors) {

		sfv.validate(sf, errors);

		ModelAndView mav = new ModelAndView();

		if (errors.hasErrors()) {
			mav.addObject("searchForm", sf);
			mav.setViewName("publication/search");
			return mav;
		} else {
			mav.addObject("pList", publications.getSome(sf.build()));
			return mav;
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("publicationId") Publication p) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("publication", p);
		mav.addObject("commentForm", new CommentForm());
		mav.addObject("showPublisher", false);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView comment(@RequestParam("publicationId") Publication p,
			CommentForm cf, Errors errors) {

		cfv.validate(cf, errors);

		ModelAndView mav = new ModelAndView();

		if (errors.hasErrors()) {
			mav.addObject("showPublisher", false);
		} else {
			mav.addObject("showPublisher", true);

			cf.build().sendMailTo(p.getPublisher());
		}

		mav.addObject("publication", p);
		mav.setViewName("publication/view");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void viewPhoto(@RequestParam("imageId") Photo photo,
			HttpServletResponse resp) {
		if (photo == null) {
			return;
		}
		resp.reset();
		resp.setBufferSize(1024);
		resp.setContentType("image/jpeg");
		resp.setHeader("Content-Disposition", "inline; filename=\"imagen"
				+ photo.getId() + "\"");
		resp.setContentLength(photo.getSize());
		try {
			InputStream input = photo.getInputStream();
			ServletOutputStream output = resp.getOutputStream();
			IOUtils.copy(input, output);
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView editPhotos(@RequestParam("publicationId") Publication p) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("publication", p);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	protected ModelAndView deletePhoto(
			@RequestParam("publicationId") Publication p,
			@RequestParam("imageId") Photo photo) {
		ModelAndView mav = new ModelAndView();
		// if(p.getUserId() != (Integer)req.getSession().getAttribute("userId"))
		// {
		// resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		// return;
		// }
		p.deletePhoto(photo);
		mav.addObject("publication", p);
		mav.setViewName("publication/editPhotos");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	protected ModelAndView uploadPhoto(HttpServletRequest req) {
		String error = "";
		ModelAndView mav = new ModelAndView();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		// if(p.getUserId() != (Integer)req.getSession().getAttribute("userId"))
		// {
		// resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		// return;
		// }
		Integer publicationId = null;
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> fields = upload.parseRequest(req);
			Iterator<FileItem> it = fields.iterator();
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				if (fileItem.getFieldName().equals("publicationId")) {
					publicationId = Integer.valueOf(fileItem.getString());
				} else {
					Photo image = createPhotoFromFileItem(fileItem,
							publicationId);
					if (image != null) {
						publications.get(publicationId).addPhoto(image);
					}
				}
			}
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Publication p = publications.get(publicationId);
		mav.addObject("error", error);
		mav.addObject("publication", p);
		mav.setViewName("publication/editPhotos");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView modify(@RequestParam("publicationId") Publication p) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("publicationForm", new PublicationForm(p));

		mav.setViewName("publication/ABM");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("publicationForm", new PublicationForm());

		mav.setViewName("publication/ABM");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveChanges(PublicationForm pf, Errors errors,
			@ModelAttribute("userId") int ui) {

		pfv.validate(pf, errors);

		ModelAndView mav = new ModelAndView();

		if (errors.hasErrors()) {
			mav.addObject("publicationForm", pf);
			mav.setViewName("publication/ABM");
			return mav;
		}

		Publication p = pf.build();
		if(p.isNew()){
			publications.add(p);
		}else{
			Publication old = publications.get(p.getId());
			old.update(p);
		}

		return new ModelAndView("redirect:../user/publications");

	}

	private Photo createPhotoFromFileItem(FileItem fileItem, int publicationId)
			throws IOException {
		int size = (int) fileItem.getSize();
		if (size > 5000000) {
			throw new IllegalArgumentException(
					"Tama�o del archivo demasiado grande.");
		}
		if (size == 0) {
			throw new IllegalArgumentException("Debe seleccionar una imagen.");
		}
		if (!validExtension(fileItem.getName())) {
			throw new IllegalArgumentException("Formato de imagen invalido.");
		}
		Photo image = new Photo(0, publicationId, fileItem.getInputStream());

		return image;
	}

	private boolean validExtension(String name) {
		String[] aux = name.split("\\.");
		if (aux.length > 0) {
			String extension = aux[aux.length - 1];
			if (extension.equals("bmp") || extension.equals("png")
					|| extension.equals("jpg")) {
				return true;
			}
		}
		return false;
	}

}
