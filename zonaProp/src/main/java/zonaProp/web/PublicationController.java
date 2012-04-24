package zonaProp.web;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zonaProp.services.ComboService;
import zonaProp.services.PublicationService;
import zonaProp.transfer.bussiness.Publication;
import zonaProp.transfer.forms.Combo;
import zonaProp.transfer.forms.PublicationForm;
import zonaProp.transfer.forms.VisitForm;
import zonaProp.validators.VisitFormValidator;
import zonaProp.web.command.CommentForm;

@Controller
public class PublicationController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView search(){
		ComboService cs = ComboService.getInstance();
		List<Combo> typeList = cs.getTypes();
		List<Combo> oTypeList = cs.getOperationTypes();

		ModelAndView mav = new ModelAndView();
		mav.addObject("typeList", typeList);
		mav.addObject("oTypeList", oTypeList);
		return mav;

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
	public ModelAndView comment(@RequestParam("publicationId") Publication p, @RequestParam("commentForm") CommentForm cf, Errors errors){
		ModelAndView mav = new ModelAndView();
		PublicationService ps = PublicationService.getInstance();
		ps.sendMailToPublisher(p, cf.build());
		mav.addObject("showPublisher", true);
		mav.addObject("publication", p);
		mav.setViewName("publication/view.jsp");
		return mav;
	}
}
