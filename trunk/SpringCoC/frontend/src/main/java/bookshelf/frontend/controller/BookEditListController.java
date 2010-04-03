package bookshelf.frontend.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import bookshelf.core.constants.WebConst;
import bookshelf.core.facade.book.BookFacade;
import bookshelf.model.object.SelectedBooksDTO;

@Controller
@RequestMapping("/bookListToEdit.do")
public class BookEditListController extends BaseController {

	private static final Logger LOG = Logger.getLogger(BookEditListController.class);
	
	@Autowired
	@Qualifier(value="bookFacade")
	private BookFacade bookFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public Object prepareForm(Model model) throws Exception {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Preparing form to show edit book list");
		}
		
		SelectedBooksDTO dto = bookFacade.findAllBooks();
		model.addAttribute(WebConst.ATTRIBUTE.FREE_BOOKS, dto);
		
		return WebConst.VIEWS.BOOK_LIST_TO_EDIT;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object submitForm(SelectedBooksDTO allBooks, BindingResult result, Model model) throws Exception {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Processing add book...");
		}
		
		validate(allBooks, result);
				
		if(result.hasErrors()){
			SelectedBooksDTO dto = bookFacade.findAllBooks();
			model.addAttribute(WebConst.ATTRIBUTE.FREE_BOOKS, dto);
			
			return saveErrorsAndReturnToForm(model, result);
		}
		
		return new RedirectView(WebConst.ACTIONS.EDIT_BOOK+"?bookId="+allBooks.getBookId());
	}
	
	private Object saveErrorsAndReturnToForm(Model model, Errors errors){
		
		model.addAttribute(WebConst.ATTRIBUTE.ERRORS, errors);
		return WebConst.VIEWS.BOOK_LIST_TO_EDIT;
	}
}
