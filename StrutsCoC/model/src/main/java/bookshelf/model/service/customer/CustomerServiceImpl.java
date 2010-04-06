package bookshelf.model.service.customer;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import bookshelf.model.binder.CustomerBinder;
import bookshelf.model.dao.customer.CustomerDao;
import bookshelf.model.helper.LogHelper;
import bookshelf.model.object.Customer;

public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOG = Logger.getLogger(CustomerService.class);
	
	@Autowired
	@Qualifier(value="customerBinder")
	private CustomerBinder customerBinder;
	
	@Autowired
	@Qualifier(value="customerDao")
	private CustomerDao customerDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAllCustomers() {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to find all customers");
		}
		
		List<Customer> customers = customerDao.find(
				customerBinder.bindCriteriaToFindAllCustomers());
		
		if(LOG.isDebugEnabled()){
			if(customerBinder.isEmpty(customers)){
				LOG.debug("No customers was found");
			}else{
				LOG.debug("Found customers "+LogHelper.getModelAsString(customers));
			}
		}
		
		return customers == null ? Collections.EMPTY_LIST : customers;
	}

	public Customer getCustomerById(Long custId) {
		
		if (custId == null) {
			throw new IllegalArgumentException("Customer id can not be null");
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to get customer with id "+custId);
		}
	
		Customer cust = customerDao.get(custId);

		
		if(LOG.isDebugEnabled()){
			if(customerBinder.isEmpty(cust)){
				LOG.debug("No customers was found with id "+custId);
			}else{
				LOG.debug("Found customer "+cust);
			}
		}
		
		return cust;
	}
	
	public void saveCustomer(Customer cust) {
		
		if (cust == null) {
			throw new IllegalArgumentException("Customer can not be null");
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Calling method to save customer "+cust);
		}

		customerDao.save(cust);
	}
	
	public void setCustomerBinder(CustomerBinder customerBinder) {
		this.customerBinder = customerBinder;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
}
