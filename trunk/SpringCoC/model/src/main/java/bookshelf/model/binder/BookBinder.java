package bookshelf.model.binder;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import bookshelf.model.object.Book;
import bookshelf.model.object.BookState;

public class BookBinder extends BaseBinder{

	public DetachedCriteria bindCriteriaForAvailableBooks(){
		
		DetachedCriteria crit = DetachedCriteria.forClass(Book.class, "book").
		createAlias("book.status", "status");
		crit.add(Restrictions.eq("status.state", BookState.FREE));
		
		return crit;	
	}
	
	public DetachedCriteria bindCriteriaToGetBooksById(List<Long> bookIds){
		
		DetachedCriteria crit = DetachedCriteria.forClass(Book.class, "book");
		crit.add(Restrictions.in("id", bookIds));
		
		return crit;
	}
	
	public DetachedCriteria bindCriteriaToFindAllBooks(){
		
		return DetachedCriteria.forClass(Book.class);
	}
}
