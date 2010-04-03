package bookshelf.model.binder;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import bookshelf.model.object.User;

public class UserBinder extends BaseBinder{
	
	public DetachedCriteria bindUserSearchCriteria(String login, String password) {
		
		if(isEmpty(login) || isEmpty(password)) {
			throw new IllegalArgumentException("Login and password can not be null");
		}
		
		DetachedCriteria crit = DetachedCriteria.forClass(User.class);
		crit.add(Restrictions.eq("login", login));
		crit.add(Restrictions.eq("password", password));
		
		return crit;
	}
}
