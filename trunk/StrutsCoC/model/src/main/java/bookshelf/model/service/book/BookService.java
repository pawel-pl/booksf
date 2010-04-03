package bookshelf.model.service.book;

import java.util.List;

import bookshelf.model.object.Book;
import bookshelf.model.object.BookState;
import bookshelf.model.object.Customer;

public interface BookService {

	public List<Book> findAvailbaleBooks();
	
	public void changeBookStatus(BookState newState, Customer cust, List<Long> bookIds);
	
	public List<Book> findAllBooks();
	
	public Book getBookById(Long id);
	
	public void saveBook(Book book);
}
