package core.ejb.logic.dao;

import java.util.List;

import javax.ejb.Local;

import core.ejb.model.BaseModel;
import core.ejb.model.Product;
import core.ejb.model.Supplier;

/**
 * Object provides base functionality for operating
 * on data base
 *
 */
@Local
public interface ProductDao {

	/**
	 * Method retrieves objects by id.
	 * 
	 * @param clazz - type of the object
	 * @param id - identifier of the object
	 */
	public <T extends BaseModel> T getObjectById(Class<T> clazz, Long id);
	
	/**
	 * Method persists objects in data base.
	 * 
	 * @param object2Save - object to persist
	 */
	public void save(BaseModel object2Save);
	
	/**
	 * Method updates objects state in data base.
	 * 
	 * @param object2Update - object to update
	 */
	public void update(BaseModel object2Update);
	
	/**
	 * Method removes objects from data base.
	 * 
	 * @param object2Remove - object to remove
	 */
	public void delete(BaseModel object2Remove);
	
	/**
	 * Method retrieves all {#link Product} from data base.
	 */
	public List<Product> findAllProducts();
	
	/**
	 * Method retrieves all {#link Supplier} from data base.
	 * 
	 * @param object2Remove - object to remove
	 */
	public List<Supplier> findAllSuppliers();
	
	/**
	 * Method retrieves all {#link Product}, which matches specified criteria.
	 * 
	 * @param name - name of the product
	 * @param quantity - quantity of the product
	 * @param supplierId - product's supplier identifier
	 */
	public List<Product> findProductsByName(String name, Integer quantity, Long supplierId);
}
