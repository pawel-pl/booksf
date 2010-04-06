package bookshelf.core.facade.customer;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import bookshelf.model.object.Customer;
import bookshelf.model.service.customer.CustomerService;

public class CustomerFacadeImpl implements CustomerFacade {

	private static final Logger LOG = Logger.getLogger(CustomerFacade.class);
	
	@Autowired
	@Qualifier(value="customerService")
	private CustomerService customerService;
	
	public List<Customer> findAllCustomers() {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to find all customers");
		}
		
		return customerService.findAllCustomers();
	}
	
	public void saveOrUpdateCustomer(Customer cust) throws Exception {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to save or update customer" +cust);
		}
		
		customerService.saveCustomer(cust);
	}
	
	public Customer getCustomerById(Long custId) {
		
		return customerService.getCustomerById(custId);
	}
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}

