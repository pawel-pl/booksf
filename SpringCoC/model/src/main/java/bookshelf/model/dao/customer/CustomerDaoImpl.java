package bookshelf.model.dao.customer;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bookshelf.model.dao.BaseDao;
import bookshelf.model.object.Customer;

public class CustomerDaoImpl extends BaseDao implements CustomerDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> find(DetachedCriteria criteria) {
		
		return getHibernateTemplate().findByCriteria(criteria);
	}
	
	public Customer get(Long id) {
		
		return (Customer)getHibernateTemplate().get(Customer.class, id);
	}
	
	public void save(Customer cust) {
		
		getHibernateTemplate().saveOrUpdate(cust);
	}
}
