package bookshelf.frontend.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import bookshelf.core.constants.WebConst;
import bookshelf.core.exception.ErrorMsgHolder;
import bookshelf.core.facade.book.BookFacade;
import bookshelf.core.facade.customer.CustomerFacade;
import bookshelf.model.object.Customer;
import bookshelf.model.object.SelectedBooksDTO;

@Controller
@RequestMapping("/addBook.do")
@SessionAttributes(WebConst.ATTRIBUTE.FREE_BOOKS)
public class AddBookController extends BaseController{

	private static final Logger LOG = Logger.getLogger(AddBookController.class);
	
	@Autowired
	@Qualifier(value="customerFacade")
	private CustomerFacade customerFacade;
	
	@Autowired
	@Qualifier(value="bookFacade")
	private BookFacade bookFacade;
	
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields(new String[] {"id"});
    }
    
	@RequestMapping(method = RequestMethod.GET)
	public Object prepareForm(@RequestParam("custId") Long custId, Model model) throws Exception {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Preparing form to show availableBooks");
		}
		
		Customer cust = customerFacade.getCustomerById(custId.intValue());
		
		if (cust == null) {
			ErrorMsgHolder msgHolder = new ErrorMsgHolder();
			msgHolder.addError("object.with.id.not.found", new Object[]{custId});
			Map<String, Object> attribs = new HashMap<String, Object>();
			attribs.put(WebConst.ATTRIBUTE.GLOBAL_ERROR, msgHolder);
			attribs.put(WebConst.ATTRIBUTE.CUSTOMERS, customerFacade.findAllCustomers());
			
			return new ModelAndView(WebConst.VIEWS.CUSTOMERS, attribs);
		}
		
		SelectedBooksDTO dto = bookFacade.findAvailableBooks();
		dto.setCustomerId(custId);
		model.addAttribute(WebConst.ATTRIBUTE.FREE_BOOKS, dto);
		model.addAttribute(WebConst.ATTRIBUTE.CUSTOMER, cust);
		
		return WebConst.VIEWS.RENT_BOOK;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object submitForm(SelectedBooksDTO freeBooks, BindingResult result, Model model, HttpServletRequest request) throws Exception {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Processing add book...");
		}
		
		validate(freeBooks, result);
				
		if(result.hasErrors()){
			freeBooks.setBooks(bookFacade.findAvailableBooks().getBooks());
			model.addAttribute(WebConst.ATTRIBUTE.FREE_BOOKS, freeBooks);
			model.addAttribute(WebConst.ATTRIBUTE.CUSTOMER, customerFacade.getCustomerById(freeBooks.getCustomerId().intValue()));
			
			return saveErrorsAndReturnToForm(model, result);
		}

		bookFacade.rentSelectedBooks(freeBooks, customerFacade.getCustomerById(freeBooks.getCustomerId().intValue()));
		model.addAttribute(WebConst.ATTRIBUTE.CUSTOMER, customerFacade.getCustomerById(freeBooks.getCustomerId().intValue()));
		
		return WebConst.VIEWS.CUSTOMER;
	}
	
	private Object saveErrorsAndReturnToForm(Model model, Errors errors){
		
		model.addAttribute(WebConst.ATTRIBUTE.ERRORS, errors);
		return WebConst.VIEWS.RENT_BOOK;
	}
	
}
