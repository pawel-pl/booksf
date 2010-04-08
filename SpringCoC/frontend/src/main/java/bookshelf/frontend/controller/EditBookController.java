package bookshelf.frontend.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import bookshelf.core.constants.WebConst;
import bookshelf.core.exception.ErrorMsgHolder;
import bookshelf.core.facade.book.BookFacade;
import bookshelf.model.object.Book;

@Controller
@RequestMapping("/editBook.do")
@SessionAttributes(WebConst.ATTRIBUTE.BOOK)
public class EditBookController extends BaseController {
	
	private static final Logger LOG = Logger.getLogger(EditBookController.class);
	
	@Autowired
	@Qualifier(value="bookFacade")
	private BookFacade bookFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public Object prepareForm(@RequestParam("bookId") Long bookId, Model model) throws Exception {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Preparing form to show book for edit");
		}
		
		if(bookId == null){
			ErrorMsgHolder msgHolder = new ErrorMsgHolder();
			msgHolder.addError("request.param.can.not.found", new Object[]{"bookId"});
			Map<String, Object> attribs = new HashMap<String, Object>();
			attribs.put(WebConst.ATTRIBUTE.GLOBAL_ERROR, msgHolder);
			attribs.put(WebConst.ATTRIBUTE.FREE_BOOKS, bookFacade.findAllBooks());
			return new ModelAndView(WebConst.VIEWS.BOOK_LIST_TO_EDIT, attribs);
		}
		
		Book book = bookFacade.getBookById(bookId);
		
		if (book == null) {
			ErrorMsgHolder msgHolder = new ErrorMsgHolder();
			msgHolder.addError("book.with.id.not.found", new Object[]{book});
			Map<String, Object> attribs = new HashMap<String, Object>();
			attribs.put(WebConst.ATTRIBUTE.GLOBAL_ERROR, msgHolder);
			attribs.put(WebConst.ATTRIBUTE.FREE_BOOKS, bookFacade.findAllBooks());
			return new ModelAndView(WebConst.VIEWS.BOOK_LIST_TO_EDIT, attribs);
		}
		
		model.addAttribute(WebConst.ATTRIBUTE.BOOK, book);
		
		return WebConst.VIEWS.BOOK_EDIT;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object submitForm(Book book, BindingResult result, Model model) throws Exception {
		
		if(result.hasErrors()){
			return WebConst.VIEWS.BOOK_EDIT;
		}
		
		validate(book, result);
		
		if(result.hasErrors()){
			return WebConst.VIEWS.BOOK_EDIT;
		}
		
		bookFacade.saveBook(book);
		
		return new ModelAndView(WebConst.VIEWS.BOOK_LIST_TO_EDIT,
				WebConst.ATTRIBUTE.FREE_BOOKS, bookFacade.findAllBooks());
	}
}
