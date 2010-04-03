package bookshelf.core.facade.customer;

import java.util.List;

import bookshelf.model.object.Customer;

public interface CustomerFacade {

	public List<Customer> findAllCustomers() throws Exception;
	
	public Customer getCustomerById(Integer custId);
	
	public void saveOrUpdateCustomer(Customer cust) throws Exception;
}
