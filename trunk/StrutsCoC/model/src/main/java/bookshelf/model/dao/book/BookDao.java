package bookshelf.model.dao.book;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bookshelf.model.object.Book;

public interface BookDao {

	public List<Book> find(DetachedCriteria crit);
	
	public void saveOrUpdate(List<Book> books);
	
	public Book get(Long id);
	
	public void save(Book book);
}
