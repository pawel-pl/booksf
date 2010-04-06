package bookshelf.frontend.action;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;

import bookshelf.core.constants.WebConst.RESULT;
import bookshelf.core.constants.WebConst.VIEWS;
import bookshelf.core.facade.book.BookFacade;
import bookshelf.model.object.Book;
import bookshelf.model.object.SelectedBooksDTO;

import com.opensymphony.xwork2.Action;

@Results({
	  @Result(name=Action.INPUT, location=VIEWS.BOOK_EDIT_FORM),
	  @Result(name=RESULT.BOOK_EDIT_LIST, location=VIEWS.BOOK_EDIT_LIST)
	})
public class BookEditAction extends BookshelfSupport{

	private static final long serialVersionUID = 164584981442620600L;
	
	private static final Logger LOG = Logger.getLogger(BookEditAction.class);

	private BookFacade bookFacade;
	
	private SelectedBooksDTO selectedBooks;
	
	private Book book;
	
	@SkipValidation
	@Override
	public String execute() {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Book edit action execute");
		}

		if(book == null || book.getId() == null){
			addActionError(getText("request.param.can.not.found", Arrays.asList(new Object[]{"bookId"})));
			selectedBooks = bookFacade.findAllBooks();
			
			return RESULT.BOOK_EDIT_LIST;
		}
		
		//TODO validate
		book = bookFacade.getBookById(book.getId());
		
		if (book == null) {
			addActionError(getText("book.with.id.not.found", Arrays.asList(new Object[]{book.getId()})));
			selectedBooks = bookFacade.findAllBooks();
			
			return RESULT.BOOK_EDIT_LIST;
		}
		
        return SUCCESS;      
    }
	
	public String submit() throws Exception {
		
		//TODO validate
		
		bookFacade.saveBook(book);
		selectedBooks = bookFacade.findAllBooks();
		
		return RESULT.BOOK_EDIT_LIST;
	}

	public SelectedBooksDTO getSelectedBooks() {
		return selectedBooks;
	}

	public void setSelectedBooks(SelectedBooksDTO selectedBooks) {
		this.selectedBooks = selectedBooks;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setBookFacade(BookFacade bookFacade) {
		this.bookFacade = bookFacade;
	}

}
