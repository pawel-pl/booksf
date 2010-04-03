package bookshelf.model.binder;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;

import bookshelf.model.object.Customer;

public class CustomerBinder extends BaseBinder{

	public DetachedCriteria bindCriteriaToFindAllCustomers(){
		
		DetachedCriteria crit =  DetachedCriteria.forClass(Customer.class);
		crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return crit;
	}
}
