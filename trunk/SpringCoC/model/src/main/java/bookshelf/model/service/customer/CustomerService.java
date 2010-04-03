package bookshelf.model.service.customer;

import java.util.List;

import bookshelf.model.object.Customer;

public interface CustomerService {

	public List<Customer> findAllCustomers() throws Exception;
	
	public Customer getCustomerById(Integer custId);
	
	public void saveCustomer(Customer cust);
}
