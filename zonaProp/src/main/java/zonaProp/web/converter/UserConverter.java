package zonaProp.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zonaProp.model.user.User;
import zonaProp.model.user.UserRepo;



@Component
public class UserConverter implements Converter<String, User>{
	
	
	UserRepo users;
	
	@Autowired
	public UserConverter(UserRepo users) {
		this.users = users;
	}

	public User convert(String source) {
		return users.get(Integer.valueOf(source));
	}

}
