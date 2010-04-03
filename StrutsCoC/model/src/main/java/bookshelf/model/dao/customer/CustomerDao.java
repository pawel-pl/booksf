package bookshelf.model.dao.customer;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bookshelf.model.object.Customer;

public interface CustomerDao {

	public List<Customer> find(DetachedCriteria criteria) ;
	
	public Customer get(Long id);
	
	public void save(Customer cust);
}
