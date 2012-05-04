package zonaProp.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zonaProp.services.UserService;
import zonaProp.transfer.bussiness.User;



@Component
public class UserConverter implements Converter<String, User>{
	
	UserService us;

	@Autowired
	public UserConverter(UserService us) {
		this.us = us;
	}

	public User convert(String source) {
		return us.getUser(Integer.valueOf(source));
	}

}
