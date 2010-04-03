package bookshelf.core.facade.user;

import java.text.MessageFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import bookshelf.model.object.User;
import bookshelf.model.service.user.UserService;

public class UserFacadeImpl implements UserFacade {

	private static final Logger LOG = Logger.getLogger(UserFacade.class);
	
	@Autowired
	@Qualifier(value="userService")
	private UserService userService;
	
	public User findByLogin(String login, String password) throws Exception {
		
		if (login == null || password == null) {
			throw new IllegalArgumentException("Login and password can not be null");
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug(MessageFormat.format("Calling method to find users with login {0} and password {1}",
						login, password));
		}
		
		List<User> users = userService.findByLogin(login, password);
		
		if(users.size() > 1){
			throw new IllegalStateException(MessageFormat.format("Found more then one user with login {0} and password {1}",
					login, password));
		}
		
		return users.isEmpty() ? null : users.get(0);
	}

	public UserService getUserService() {
		return userService;
	}
	
}
