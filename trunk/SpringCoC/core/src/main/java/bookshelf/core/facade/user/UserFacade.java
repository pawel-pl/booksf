package bookshelf.core.facade.user;

import bookshelf.model.object.User;

public interface UserFacade {

	public User findByLogin(String login, String password) throws Exception;
}
