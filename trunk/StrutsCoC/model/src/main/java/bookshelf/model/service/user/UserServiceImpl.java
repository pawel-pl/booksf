package bookshelf.model.service.user;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import bookshelf.model.binder.UserBinder;
import bookshelf.model.dao.user.UserDao;
import bookshelf.model.helper.LogHelper;
import bookshelf.model.object.User;

public class UserServiceImpl implements UserService {

	private static final Logger LOG = Logger.getLogger(UserService.class);
	
	@Autowired
	@Qualifier(value="userBinder")
	private UserBinder userBinder;
	
	@Autowired
	@Qualifier(value="userDao")
	private UserDao userDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByLogin(String login, String password)
			throws Exception {
		
		if(userBinder.isEmpty(login) || userBinder.isEmpty(password)) {
			throw new IllegalArgumentException("Login and password can not be null");
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug(MessageFormat.format("Calling method to find users with login {0} and password {1}",
						login, password));
		}
		
		List<User> users = userDao.find(
				userBinder.bindUserSearchCriteria(login, password));
		
		if(LOG.isDebugEnabled()){
			if(userBinder.isEmpty(users)){
				LOG.debug(MessageFormat.format("No users was found with login {0} and password {1}",
						login, password));
			}else{
				LOG.debug("Found users "+LogHelper.getModelAsString(users));
			}
		}
		
		return users == null ? Collections.EMPTY_LIST : users;
	}

	public void setUserBinder(UserBinder userBinder) {
		this.userBinder = userBinder;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
