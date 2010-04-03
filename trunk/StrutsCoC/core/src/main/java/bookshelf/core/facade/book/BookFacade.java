package bookshelf.core.facade.book;

import bookshelf.model.object.Book;
import bookshelf.model.object.Customer;
import bookshelf.model.object.SelectedBooksDTO;

public interface BookFacade {

	public SelectedBooksDTO findAvailableBooks();
	
	public void rentSelectedBooks(SelectedBooksDTO dto, Customer cust);
	
	public void freeSelectedBooks(SelectedBooksDTO dto);
	
	public SelectedBooksDTO findAllBooks();
	
	public Book getBookById(Long bookId);
	
	public void saveBook(Book book);
}
