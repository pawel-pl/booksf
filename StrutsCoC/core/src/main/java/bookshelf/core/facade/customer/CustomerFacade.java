package bookshelf.core.facade.customer;

import java.util.List;

import bookshelf.model.object.Customer;

public interface CustomerFacade {

	public List<Customer> findAllCustomers();
	
	public Customer getCustomerById(Long custId);
	
	public void saveOrUpdateCustomer(Customer cust) throws Exception;
}
