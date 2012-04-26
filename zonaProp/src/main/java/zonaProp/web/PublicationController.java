package zonaProp.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import zonaProp.web.command.CommentForm;
import zonaProp.web.command.validator.CommentFormValidator;

@Controller
public class PublicationController {
	CommentFormValidator cfv;
	@Autowired
	public PublicationController(CommentFormValidator cfv) {
		this.cfv = cfv;
	}
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
	public ModelAndView comment(@RequestParam("publicationId") Publication p,CommentForm cf, Errors errors){
		cfv.validate(cf, errors);
		

		ModelAndView mav = new ModelAndView();
		
		if(errors.hasErrors()){
			mav.addObject("showPublisher", false);
		} else {
			mav.addObject("showPublisher", true);		
			PublicationService ps = PublicationService.getInstance();
			ps.sendMailToPublisher(p, cf.build());
		}
		

		mav.addObject("publication", p);
		mav.setViewName("publication/view");
		return mav;
	}
}
