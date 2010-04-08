package bookshelf.frontend.action;

import static com.opensymphony.xwork2.Action.INPUT;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;

import bookshelf.core.constants.WebConst.ACTIONS;
import bookshelf.core.constants.WebConst.RESULT;
import bookshelf.core.constants.WebConst.VIEWS;
import bookshelf.core.facade.customer.CustomerFacade;
import bookshelf.model.object.Customer;

@Results({
	  @Result(name=RESULT.WELLCOME, location=ACTIONS.WELLCOME, type="redirect"),
	  @Result(name=INPUT, location=VIEWS.CUSTOMER_ADD_FORM)
	})
public class CustomerAddAction extends CustomerBaseAction {

	private static final long serialVersionUID = 319668154407735763L;

	private static final Logger LOG = Logger.getLogger(CustomerAddAction.class);
	
	private CustomerFacade customerFacade;
	
	private Customer customer;
	
	@SkipValidation
	@Override
	public String execute() {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Customer add action execute");
		}
		
        return SUCCESS;      
    }
	
	public String submit() throws Exception {
		
		customerFacade.saveOrUpdateCustomer(customer);
		
		return RESULT.WELLCOME;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}
	
}
