package core.ejb.logic.dao;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import core.ejb.model.BaseModel;
import core.ejb.model.Product;
import core.ejb.model.Supplier;

/**
 * @see core.ejb.logic.dao.ProductDao
 */
@Stateless
public class ProductDaoImpl implements ProductDao, Serializable {

	private static final long serialVersionUID = -6250161905243047004L;

	private static final Logger LOG = Logger.getLogger(ProductDaoImpl.class);
	
	@PersistenceContext(unitName = "ejb_test")
	private EntityManager entityManager;

	/**
	 * @see core.ejb.logic.dao.ProductDao#getObjectById(Class, Long) 
	 */
	public <T extends BaseModel> T getObjectById(Class<T> clazz, Long id) {
		
		LOG.debug(MessageFormat.format("Finding object with id: {0} of type: {1}",
				id, clazz));
		
		return entityManager.find(clazz, id);
	}
	
	/**
	 * @see core.ejb.logic.dao.ProductDao#save(BaseModel)
	 */
	public void save(BaseModel object2Save) {
		
		LOG.debug(MessageFormat.format("Saving object of type: {0}",
				object2Save.getClass()));
		
		entityManager.persist(object2Save);
	}
	
	/**
	 * @see core.ejb.logic.dao.ProductDao#update(BaseModel)
	 */
	public void update(BaseModel object2Update) {
		
		LOG.debug(MessageFormat.format("Updating object with id: {0} of type: {1}",
				object2Update, object2Update.getClass()));
		
		entityManager.merge(object2Update);
	}
	
	/**
	 * @see core.ejb.logic.dao.ProductDao#delete(BaseModel)
	 */
	public void delete(BaseModel object2Remove) {
		
		LOG.debug(MessageFormat.format("Deleting object with id: {0} of type: {1}",
				object2Remove, object2Remove.getClass()));
		
		entityManager.remove(object2Remove);
	}
	
	/**
	 * @see core.ejb.logic.dao.ProductDao#findProductsByName(String, Integer, Long) 
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findProductsByName(String name, Integer quantity, Long supplierId){
	
		LOG.debug(MessageFormat.format("Calling method to find products by data name: {0}," +
				" quntity: {1}, supplierId {2}", name, quantity, supplierId));
		
		String query = "from Product prod inner join fetch prod.supplier sup "
			+ "where prod.name like :name and prod.quantity >= :quan";
		
		query = supplierId == null ? query : (query + " and sup.id = :supId");
		
		Query dbQuery = entityManager.createQuery(query)
			.setParameter("name", "%"+name+"%")
			.setParameter("quan", quantity);
		
		if(supplierId != null) {
			dbQuery.setParameter("supId", supplierId);
		}
		
		return dbQuery.getResultList();
	}
	
	/**
	 * @see core.ejb.logic.dao.ProductDao#findAllProducts()
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {

		LOG.debug("Calling method to find all products");
		
		List<Product> result = entityManager.createQuery("From Product p")
				.getResultList();
		
		if(result == null || result.isEmpty()){
			LOG.debug("No products was found");
		}else{
			LOG.debug("Found products");
		}
		
		return result;
	}
	
	/**
	 * @see core.ejb.logic.dao.ProductDao#findAllSuppliers() 
	 */
	@SuppressWarnings("unchecked")
	public List<Supplier> findAllSuppliers() {

		LOG.debug("Calling method to find all suppliers");
		
		List<Supplier> result = entityManager.createQuery("From Supplier s")
				.getResultList();
		
		if(result == null || result.isEmpty()){
			LOG.debug("No suppliers was found");
		}else{
			LOG.debug("Found products");
		}
		
		return result;
	}
	
}
