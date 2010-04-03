package bookshelf.model.dao.book;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bookshelf.model.dao.BaseDao;
import bookshelf.model.object.Book;

public class BookDaoImpl extends BaseDao implements BookDao {

	@SuppressWarnings("unchecked")
	public List<Book> find(DetachedCriteria crit) {
		
		return getHibernateTemplate().findByCriteria(crit);
	}
	
	public void saveOrUpdate(List<Book> books) {
		
		getHibernateTemplate().saveOrUpdateAll(books);
	}
	
	public Book get(Long id) {
		
		return (Book)getHibernateTemplate().get(Book.class, id);
	}
	
	public void save(Book book) {
		
		getHibernateTemplate().saveOrUpdate(book);
	}
}
