package bookshelf.frontend.action;

import static com.opensymphony.xwork2.Action.INPUT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;

import bookshelf.core.constants.WebConst.RESULT;
import bookshelf.core.constants.WebConst.VIEWS;
import bookshelf.core.facade.book.BookFacade;
import bookshelf.core.facade.customer.CustomerFacade;
import bookshelf.model.object.Book;
import bookshelf.model.object.Customer;
import bookshelf.model.object.SelectedBooksDTO;

@Results({
	  @Result(name=RESULT.CUSTOMERS, location=VIEWS.CUSTOMERS),
	  @Result(name=RESULT.CUSTOMER, location=VIEWS.CUSTOMER),
	  @Result(name=INPUT, location=VIEWS.REMOVE_BOOK)
	})
public class RemoveBookAction extends BookshelfSupport{

	private static final long serialVersionUID = -2861472816889272498L;

	private static final Logger LOG = Logger.getLogger(RemoveBookAction.class);
	
	private BookFacade bookFacade;
	
	private CustomerFacade customerFacade;
	
	private List<Customer> customers;
	
	private Customer customer;
	
	private SelectedBooksDTO selectedBooks;

	@SkipValidation
	@Override
	public String execute() throws Exception {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Remove book action execute");
		}
		
		customer = customerFacade.getCustomerById(customer.getId());
		
		if (customer == null) {
			addActionError(getText("object.with.id.not.found", Arrays.asList(new Object[]{customer.getId()})));
			customers = customerFacade.findAllCustomers();
			
			return RESULT.CUSTOMERS;
		}
		
		selectedBooks = new SelectedBooksDTO();
		selectedBooks.setBooks(new ArrayList<Book>(customer.getBooks()));
		
		return INPUT;
	}
	
	public String removeBook() throws Exception{
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Processing remove book...");
		}
		
		bookFacade.freeSelectedBooks(selectedBooks);
		customer = customerFacade.getCustomerById(customer.getId());
		
		return RESULT.CUSTOMER;
	}

	@Override
	public void validate() {
		
		if (selectedBooks == null || selectedBooks.getSelectedBooks() == null || selectedBooks.getSelectedBooks().isEmpty()) {
			addActionError(getText("book.not.choose.error", "Choose book"));
		}
		
		if(hasErrors()){
			customer = customerFacade.getCustomerById(customer.getId());
			selectedBooks = new SelectedBooksDTO();
			selectedBooks.setBooks(new ArrayList<Book>(customer.getBooks()));
		}
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}

}
