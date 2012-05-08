package zonaProp.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import zonaProp.services.UserService;
import zonaProp.transfer.bussiness.User;

@Controller
@SessionAttributes("userId")
public class UserController {
	
	UserService us;
	
	@Autowired
	public UserController(UserService us) {
		this.us = us;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView publications(@ModelAttribute("userId") int ui){
		
		User u = us.getUser(ui);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pList",u.getPublications());
		
		return mav;
	}
	
}
