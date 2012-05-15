package zonaProp.web;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import zonaProp.mailing.MailingService;
import zonaProp.mailing.SendMailTLS;
import zonaProp.model.repo.PublicationRepo;
import zonaProp.model.repo.UserRepo;
import zonaProp.transfer.bussiness.Photo;
import zonaProp.transfer.bussiness.PropertyServices;
import zonaProp.transfer.bussiness.Publication;
import zonaProp.transfer.bussiness.User;
import zonaProp.web.command.CommentForm;
import zonaProp.web.command.PhotoForm;
import zonaProp.web.command.PublicationForm;
import zonaProp.web.command.SearchForm;
import zonaProp.web.command.validator.CommentFormValidator;
import zonaProp.web.command.validator.PhotoFormValidator;
import zonaProp.web.command.validator.PublicationFormValidator;
import zonaProp.web.command.validator.SearchFormValidator;

@Controller
@SessionAttributes("userId")
public class PublicationController {

	PublicationFormValidator pfv;
	PhotoFormValidator photofv;
	CommentFormValidator cfv;
	SearchFormValidator sfv;
	PublicationRepo publications;
	UserRepo users;
	MailingService mailingService;
	@Autowired
	public PublicationController(PublicationFormValidator pfv, PhotoFormValidator photofv,
			CommentFormValidator cfv, SearchFormValidator sfv,
			PublicationRepo publications, UserRepo users, MailingService mailingService) {

		this.photofv = photofv;
		this.pfv = pfv;
		this.sfv = sfv;
		this.cfv = cfv;
		this.publications = publications;
		this.users = users;
		this.mailingService = mailingService;
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
		mav.addObject("searchForm", new SearchForm());
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
			mailingService.contact(cf.build(), p.getPublisher());
		}

		mav.addObject("publication", p);
		mav.addObject("searchForm", new SearchForm());
		mav.setViewName("publication/view");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	protected ModelAndView uploadPhoto(
			@RequestParam("publicationId") Publication p, PhotoForm pF,
			Errors errors, @ModelAttribute("userId") int ui) {

		if (p.getUserId() != ui) {
			return null;
		}
		photofv.validate(pF, errors);

		ModelAndView mav = new ModelAndView();

		if (!errors.hasErrors()) {
			Photo image = pF.build();
			p.addPhoto(image);
		}
		mav.addObject("publication", p);
		mav.setViewName("publication/editPhotos");
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
			ServletOutputStream output = resp.getOutputStream();
			output.write(photo.getData());
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView editPhotos(@RequestParam("publicationId") Publication p) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("publication", p);
		mav.addObject("photoForm", new PhotoForm());
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	protected ModelAndView deletePhoto(
			@RequestParam("publicationId") Publication p,
			@RequestParam("imageId") Photo photo,
			@ModelAttribute("userId") int ui) {
		ModelAndView mav = new ModelAndView();
		if (p.getUserId() != ui) {
			return null;
		}
		p.deletePhoto(photo);
		mav.addObject("publication", p);
		mav.addObject("photoForm", new PhotoForm());
		mav.setViewName("publication/editPhotos");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView modify(@RequestParam("publicationId") Publication p) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("publicationForm", new PublicationForm(p));
		mav.addObject("services", PropertyServices.values());
		mav.setViewName("publication/ABM");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("publicationForm", new PublicationForm());
		mav.addObject("services", PropertyServices.values());
		mav.setViewName("publication/ABM");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveChanges(PublicationForm pf, Errors errors,
			@ModelAttribute("userId") int ui) {

		pfv.validate(pf, errors);

		ModelAndView mav = new ModelAndView();

		User publisher = users.get(ui);

		if (errors.hasErrors()) {
			mav.addObject("publicationForm", pf);
			mav.addObject("services", PropertyServices.values());
			mav.setViewName("publication/ABM");
			return mav;
		}

		Publication p = pf.build();
		p.setPublisher(publisher);
		if (p.isNew()) {
			publications.add(p);
		} else {
			Publication old = publications.get(p.getId());
			old.update(p);
		}

		return new ModelAndView("redirect:../user/publications");

	}

}
