package bookshelf.model.service.user;

import java.util.List;
import bookshelf.model.object.User;


public interface UserService {
	
	public List<User> findByLogin(String login, String password) throws Exception;
}
