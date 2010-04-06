package bookshelf.frontend.action;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Action;

import bookshelf.core.constants.WebConst.RESULT;
import bookshelf.core.constants.WebConst.VIEWS;
import bookshelf.core.facade.customer.CustomerFacade;
import bookshelf.model.object.Customer;

@Results({
	  @Result(name=Action.INPUT, location=VIEWS.CUSTOMER_EDIT_FORM),
	  @Result(name=RESULT.CUSTOMER_EDIT_LIST, location=VIEWS.CUSTOMER_EDIT_LIST)
	})
public class CustomerEditAction extends BookshelfSupport{

	private static final long serialVersionUID = -2743573843173490648L;

	private static final Logger LOG = Logger.getLogger(CustomerEditAction.class);
	
	private CustomerFacade customerFacade;
	
	private Customer customer;
	
	private List<Customer> customers;
	
	@SkipValidation
	@Override
	public String execute() {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Customer edit action execute");
		}

		if(customer == null || customer.getId() == null){
			addActionError(getText("request.param.can.not.found", Arrays.asList(new Object[]{"bookId"})));
			customers = customerFacade.findAllCustomers();
			
			return RESULT.CUSTOMER_EDIT_LIST;
		}
		
		customer = customerFacade.getCustomerById(customer.getId());
		
		if (customer == null) {
			addActionError(getText("object.with.id.not.found", Arrays.asList(new Object[]{customer.getId()})));
			customers = customerFacade.findAllCustomers();
			
			return RESULT.CUSTOMER_EDIT_LIST;
		}
		
        return SUCCESS;      
    }

	public String submit() throws Exception {
	
		//TODO validate
		
		customerFacade.saveOrUpdateCustomer(customer);
		customers = customerFacade.findAllCustomers();
		
		return RESULT.CUSTOMER_EDIT_LIST;
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
