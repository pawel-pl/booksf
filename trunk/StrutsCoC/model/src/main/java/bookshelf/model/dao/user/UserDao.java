package bookshelf.model.dao.user;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bookshelf.model.object.User;

public interface UserDao {

	public List<User> find(DetachedCriteria criteria) ;
}
