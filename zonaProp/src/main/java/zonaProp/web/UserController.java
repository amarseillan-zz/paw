package zonaProp.web;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import zonaProp.services.UserService;
import zonaProp.transfer.bussiness.User;
import zonaProp.web.command.CommentForm;
import zonaProp.web.command.UserForm;
import zonaProp.web.command.validator.UserFormValidator;

@Controller
@SessionAttributes("userId")
public class UserController {
	
	UserService us;
	UserFormValidator ufv;
	@Autowired
	public UserController(UserService us, UserFormValidator ufv) {
		this.us = us;
		this.ufv = ufv;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView publications(@ModelAttribute("userId") int ui){
		
		User u = us.getUser(ui);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pList",u.getPublications());
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView signUp(){
		ModelAndView mav = new ModelAndView();
		mav.addObject(new UserForm());
		return mav;
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView signUp(UserForm uf, Errors errors, HttpSession s){
		ModelAndView mav;
		ufv.validate(uf,errors);
		User user = null;

		
//		List<String> errors = new UserFormValidator().check(uf);
		
		if(!errors.hasErrors()){
			user = uf.build();
			user = us.createNewUser(user);
			s.setAttribute("userId", user.getId());
			mav = new ModelAndView("redirect:../publication/search");
		} else {
			mav = new ModelAndView();
			mav.addObject("userForm",uf);
		}
		return mav;
	}
}
