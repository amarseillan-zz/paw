package zonaProp.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zonaProp.services.PublicationService;
import zonaProp.transfer.bussiness.Publication;
import zonaProp.web.command.CommentForm;
import zonaProp.web.command.PublicationForm;
import zonaProp.web.command.SearchForm;
import zonaProp.web.command.validator.CommentFormValidator;
import zonaProp.web.command.validator.SearchFormValidator;

@Controller
public class PublicationController {
	
	CommentFormValidator cfv;
	SearchFormValidator sfv;
	PublicationService ps;
	
	@Autowired
	public PublicationController(CommentFormValidator cfv, SearchFormValidator sfv, PublicationService ps) {
		this.sfv = sfv;
		this.cfv = cfv;
		this.ps = ps;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView search(){

		ModelAndView mav = new ModelAndView();
		mav.addObject("searchForm", new SearchForm());
		return mav;

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView searchResults(SearchForm sf, Errors errors){
		
		sfv.validate(sf, errors);

		ModelAndView mav = new ModelAndView();
		
		if(errors.hasErrors()){
			mav.addObject("searchForm", sf);
			mav.setViewName("publication/search");
			return mav;
		}
		else{
			mav.addObject("pList",ps.advancedSearch(sf.build()));
			return mav;
		}

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("publicationId") Publication p){
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("publication", p);
		mav.addObject("commentForm", new CommentForm());
		mav.addObject("showPublisher", false);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView comment(@RequestParam("publicationId") Publication p,CommentForm cf, Errors errors){
		
		cfv.validate(cf, errors);
		

		ModelAndView mav = new ModelAndView();
		
		if(errors.hasErrors()){
			mav.addObject("showPublisher", false);
		} 
		else {
			mav.addObject("showPublisher", true);
			ps.sendMailToPublisher(p, cf.build());
		}

		mav.addObject("publication", p);
		mav.setViewName("publication/view");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView ABM(@RequestParam("pid") Publication p){
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("publicationForm", p==null?new PublicationForm():new PublicationForm(p));
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveChanges(PublicationForm pf, Errors errors){
		ModelAndView mav = new ModelAndView();
		
		
		return mav;
	}
	
}
