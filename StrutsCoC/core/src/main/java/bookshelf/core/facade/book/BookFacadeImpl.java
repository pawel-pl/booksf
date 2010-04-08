package bookshelf.core.facade.book;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import bookshelf.model.object.Book;
import bookshelf.model.object.BookState;
import bookshelf.model.object.Customer;
import bookshelf.model.object.SelectedBooksDTO;
import bookshelf.model.service.book.BookService;

public class BookFacadeImpl implements BookFacade {

	private static final Logger LOG = Logger.getLogger(BookFacade.class);
	
	@Autowired
	@Qualifier(value="bookService")
	private BookService bookService;
	
	public SelectedBooksDTO findAvailableBooks() {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to find available books");
		}
		
		SelectedBooksDTO dto = new SelectedBooksDTO();
		
		dto.setBooks(bookService.findAvailbaleBooks());
		
		return dto;
	}
	
	public Book getBookById(Long bookId) {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to get book by Id "+bookId);
		}
		
		return bookService.getBookById(bookId);
	}
	
	public void saveBook(Book book) {
		
		if(book == null || book.getId() == null){
			throw new IllegalArgumentException("Book can not be null");
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to save book "+book);
		}
		Book loadedBook = getBookById(book.getId());
		copyNotNullFields(book, loadedBook);
		bookService.saveBook(loadedBook);
	}
	
	public SelectedBooksDTO findAllBooks() {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to find all books");
		}
		
		SelectedBooksDTO dto = new SelectedBooksDTO();
		
		dto.setBooks(bookService.findAllBooks());
		
		return dto;
	}
	
	public void rentSelectedBooks(SelectedBooksDTO dto, Customer cust){
		
		if(dto == null || cust == null){
			throw new IllegalArgumentException("DTO and Customer can not be null");
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to rent books "+dto.getSelectedBooks()+" for customer "+cust);
		}
		
		bookService.changeBookStatus(BookState.ON_LOAN, cust, dto.getSelectedBooks());
	}
	
	public void freeSelectedBooks(SelectedBooksDTO dto) {
		
		if(dto == null ){
			throw new IllegalArgumentException("DTO can not be null");
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to free books "+dto.getSelectedBooks());
		}
		
		bookService.changeBookStatus(BookState.FREE, null, dto.getSelectedBooks());
	}
	
	private void copyNotNullFields(Object o1, Object o2) {
		
		try{
			Field[] sourceFields = o1.getClass().getDeclaredFields();
			AccessibleObject.setAccessible(sourceFields, true);
			for(Field sourceField : sourceFields){
				if(!isStatic(sourceField)){
					Object value = sourceField.get(o1);
					if(value != null){
						Field destField = o2.getClass().getDeclaredField(sourceField.getName());
						AccessibleObject.setAccessible(new AccessibleObject[]{destField}, true);
						destField.set(o2, value);
					}
				}
			}
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	private boolean isStatic(Field field){

		return Modifier.isStatic(field.getModifiers());
	}
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
}
