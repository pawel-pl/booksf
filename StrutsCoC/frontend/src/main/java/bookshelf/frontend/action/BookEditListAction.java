package bookshelf.frontend.action;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.validation.SkipValidation;

import bookshelf.core.facade.book.BookFacade;
import bookshelf.model.object.SelectedBooksDTO;

public class BookEditListAction extends BookshelfSupport{

	private static final long serialVersionUID = 8637767579713965321L;

	private BookFacade bookFacade;
	
	private SelectedBooksDTO selectedBooks;
	
	private static final Logger LOG = Logger.getLogger(BookEditListAction.class);
	
	@SkipValidation
	@Override
	public String execute() throws Exception {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Book list to edit execute");
		}
		
		selectedBooks = bookFacade.findAllBooks();
		
		return SUCCESS;
	}

	public SelectedBooksDTO getSelectedBooks() {
		return selectedBooks;
	}

	public void setSelectedBooks(SelectedBooksDTO selectedBooks) {
		this.selectedBooks = selectedBooks;
	}

	public void setBookFacade(BookFacade bookFacade) {
		this.bookFacade = bookFacade;
	}
	
}
