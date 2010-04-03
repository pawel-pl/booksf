package bookshelf.model.service.book;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import bookshelf.model.binder.BookBinder;
import bookshelf.model.dao.book.BookDao;
import bookshelf.model.helper.LogHelper;
import bookshelf.model.object.Book;
import bookshelf.model.object.BookState;
import bookshelf.model.object.Customer;

public class BookServiceImpl implements BookService {

	private static final Logger LOG = Logger.getLogger(BookService.class);
	
	@Autowired
	@Qualifier(value="bookBinder")
	private BookBinder bookBinder;
	
	@Autowired
	@Qualifier(value="bookDao")
	private BookDao bookDao;
	
	@SuppressWarnings("unchecked")
	public List<Book> findAvailbaleBooks(){
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to find available books");
		}
		
		List<Book> freeBooks = bookDao.find(bookBinder.bindCriteriaForAvailableBooks());
	
		if(LOG.isDebugEnabled()){
			if(bookBinder.isEmpty(freeBooks)){
				LOG.debug("No freeBooks was found");
			}else{
				LOG.debug("Found free books "+LogHelper.getModelAsString(freeBooks));
			}
		}
		
		return freeBooks == null ? Collections.EMPTY_LIST : freeBooks;
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> findAllBooks(){
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to find all books");
		}
		
		List<Book> allBooks = bookDao.find(bookBinder.bindCriteriaToFindAllBooks());
	
		if(LOG.isDebugEnabled()){
			if(bookBinder.isEmpty(allBooks)){
				LOG.debug("No books was found");
			}else{
				LOG.debug("Found books "+LogHelper.getModelAsString(allBooks));
			}
		}
		
		return allBooks == null ? Collections.EMPTY_LIST : allBooks;
	}
	
	public Book getBookById(Long id){
		
		if(id == null){
			throw new IllegalArgumentException("Book id can not be null");
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to get book by id");
		}
		
		Book book = bookDao.get(id);
	
		if(LOG.isDebugEnabled()){
			if(bookBinder.isEmpty(book)){
				LOG.debug("Books with id not found "+id);
			}else{
				LOG.debug("Got book "+book);
			}
		}
		
		return book;
	}
	
	public void saveBook(Book book){
		
		if(book == null){
			throw new IllegalArgumentException("Book can not be null");
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to save book "+book);
		}
		
		bookDao.save(book);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void changeBookStatus(BookState newState, Customer cust, List<Long> bookIds){
		
		if(newState == null || bookIds == null || bookIds.isEmpty()){
			throw new IllegalArgumentException();
		}
		
		List<Book> books = bookDao.find(bookBinder.bindCriteriaToGetBooksById(bookIds));
		
		if(LOG.isDebugEnabled()){
			if(bookBinder.isEmpty(books)){
				LOG.debug("No freeBooks was found with id "+bookIds);
			}else{
				LOG.debug("Found books "+LogHelper.getModelAsString(books));
			}
		}
		
		if(bookBinder.isEmpty(bookIds)){
			throw new IllegalStateException("No freeBooks was found with id "+bookIds);
		}
		
		for(Book book : books){
			book.getStatus().setState(newState);
			book.setCustomer(cust);
		}
		
		bookDao.saveOrUpdate(books);
	}

	public void setBookBinder(BookBinder bookBinder) {
		this.bookBinder = bookBinder;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
}
