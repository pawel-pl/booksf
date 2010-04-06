package bookshelf.frontend.action;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;

import bookshelf.core.constants.WebConst.RESULT;
import bookshelf.core.constants.WebConst.VIEWS;
import bookshelf.core.facade.customer.CustomerFacade;
import bookshelf.model.object.Customer;

@Results({
	  @Result(name=RESULT.CUSTOMERS, location=VIEWS.CUSTOMERS)
	})
public class CustomerAction extends BookshelfSupport{

	private static final long serialVersionUID = 8779140371782719452L;

	private static final Logger LOG = Logger.getLogger(CustomerAction.class);
	
	private CustomerFacade customerFacade;
	
	private Customer customer;
	
	private List<Customer> customers;
	
	@SkipValidation
	@Override
	public String execute() {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Customer action execute");
		}

		customer = customerFacade.getCustomerById(customer.getId());
		
		if (customer == null) {
			addActionError(getText("object.with.id.not.found", Arrays.asList(new Object[]{customer.getId()})));
			customers = customerFacade.findAllCustomers();
			
			return RESULT.CUSTOMERS;
		}
		
        return SUCCESS;      
    }

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}
	
}
