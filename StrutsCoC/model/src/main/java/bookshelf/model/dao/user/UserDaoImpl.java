package bookshelf.model.dao.user;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bookshelf.model.dao.BaseDao;
import bookshelf.model.object.User;

public class UserDaoImpl extends BaseDao implements UserDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<User> find(DetachedCriteria criteria) {
		
		return getHibernateTemplate().findByCriteria(criteria);
	}

}
