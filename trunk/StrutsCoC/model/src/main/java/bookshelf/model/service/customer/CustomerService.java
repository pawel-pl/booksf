package bookshelf.model.service.customer;

import java.util.List;

import bookshelf.model.object.Customer;

public interface CustomerService {

	public List<Customer> findAllCustomers();
	
	public Customer getCustomerById(Long custId);
	
	public void saveCustomer(Customer cust);
}
