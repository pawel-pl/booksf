package bookshelf.frontend.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.validation.SkipValidation;

import bookshelf.core.facade.customer.CustomerFacade;
import bookshelf.model.object.Customer;

public class CustomerEditListAction extends BookshelfSupport{

	private static final long serialVersionUID = 6684937090296833560L;

	private static final Logger LOG = Logger.getLogger(CustomerEditListAction.class);
	
	private CustomerFacade customerFacade;
	
	private List<Customer> customers;
	
	@SkipValidation
	@Override
	public String execute() throws Exception {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Customers list to edit execute");
		}
		
		customers = customerFacade.findAllCustomers();
		
		return SUCCESS;
	}

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
}
