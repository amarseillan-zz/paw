package zonaProp.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import zonaProp.model.repo.DuplicatedUserException;
import zonaProp.model.repo.UserRepo;
import zonaProp.transfer.bussiness.User;
import zonaProp.web.command.LoginUserForm;
import zonaProp.web.command.UserForm;
import zonaProp.web.command.validator.LoginUserFormValidator;
import zonaProp.web.command.validator.UserFormValidator;

@Controller
@SessionAttributes("userId")
public class UserController {
	LoginUserFormValidator lufv;
	UserRepo users;
	UserFormValidator ufv;

	@Autowired
	public UserController(UserRepo users, UserFormValidator ufv,
			LoginUserFormValidator lufv) {
		this.users = users;
		this.ufv = ufv;
		this.lufv = lufv;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView publications(@ModelAttribute("userId") int ui) {

		User u = users.get(ui);

		ModelAndView mav = new ModelAndView();

		mav.addObject("pList", u.getPublications());

		return mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView signUp() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(new UserForm());
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView signUp(HttpSession s, UserForm uf, Errors errors) {
		ModelAndView mav;
		ufv.validate(uf, errors);
		User user = null;

		// List<String> errors = new UserFormValidator().check(uf);
		mav = null;
		if (!errors.hasErrors()) {
			user = uf.build();
			try {
				users.add(user);
				s.setAttribute("userId", user.getId());
				mav = new ModelAndView("redirect:../publication/search");
			} catch (DuplicatedUserException e) {
				//TODO hacer que se cargue un error de que ya est� en uso ese nombre
			}
		} else {
			mav = new ModelAndView();
			mav.addObject("userForm", uf);
		}
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest req, HttpSession s) {
		ModelAndView mav = new ModelAndView();
		LoginUserForm luf = new LoginUserForm();
		User user = null;
		if (req.getSession().getAttribute("userId") != null
				&& req.getSession().getAttribute("userId").equals("")) {
			if ( users.authenticate(luf.getUsername(), luf.getPassword()) ) {
				user = users.get(luf.getUsername());
				s.setAttribute("userId", user.getId());
				mav = new ModelAndView("redirect:../publication/search");
			} else {
				luf.setRemember("off");
			}
		}
		for (Cookie c : req.getCookies()) {
			if (c.getName().equals("username")) {
				luf.setUsername(c.getValue());
				luf.setRememberu("on");
			}
			if (c.getName().equals("userid")) {
				if ( users.authenticate(luf.getUsername(), luf.getPassword()) ){
					user = users.get(luf.getUsername());
					s.setAttribute("userId", user.getId());
					mav = new ModelAndView("redirect:../user/publications");
				} else {
					luf.setRemember("off");
				}
			}
		}
		if (user == null)
			mav.addObject(luf);

		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(LoginUserForm luf, Errors errors, HttpSession s,
			HttpServletResponse resp) {
		lufv.validate(luf, errors);
		ModelAndView mav = null;

		User user=luf.build(users);
		if ( user!=null ) {
			s.setAttribute("userId", user.getId());
			if ("on".equals(luf.getRemember())) {
				Cookie c = new Cookie("userid", String.valueOf(user.getId()));
				c.setMaxAge(30 * 24 * 60 * 60);
				resp.addCookie(c);
			}
			if ("on".equals(luf.getRememberu())) {
				Cookie c = new Cookie("username", String.valueOf(luf
						.getUsername()));
				c.setMaxAge(30 * 24 * 60 * 60);
				resp.addCookie(new Cookie("username", String.valueOf(luf
						.getUsername())));
			} else {
				resp.addCookie(new Cookie("username", ""));
			}
			mav = new ModelAndView("redirect:../user/publications");
		} else {
			errors.reject("invalidUser");
			mav = new ModelAndView();
		}
		// mav.addObject(new LoginUserForm());
		return mav;

	}

}
