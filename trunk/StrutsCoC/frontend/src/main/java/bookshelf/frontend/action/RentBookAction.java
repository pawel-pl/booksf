package bookshelf.frontend.action;

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
public class RentBookAction extends BookshelfSupport {

	private static final long serialVersionUID = -2296396007990917677L;

	private static final Logger LOG = Logger.getLogger(RentBookAction.class);
	
	private CustomerFacade customerFacade;
	
	private List<Customer> customers;
	
	@SkipValidation
	@Override
	public String execute() throws Exception {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Rent book execute");
		}
		
		customers = customerFacade.findAllCustomers();
		
		return RESULT.CUSTOMERS;
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
