package core.ejb.logic.service;

import java.util.List;

import javax.ejb.Remote;

import core.ejb.model.BaseModel;
import core.ejb.model.Product;
import core.ejb.model.Supplier;

/**
 * Object provides business logic for operations
 * on Product and Supplier
 */
@Remote
public interface ProductService {
	
	/**
	 * Method provides logic for removing {#link Product}.
	 * 
	 * @param productId - identifier of the product with will be removed
	 */
	public void deleteProduct(Long productId);
	
	/**
	 * Method provides logic for adding new {#link Product}.
	 * 
	 * @param prod2Add - product to add
	 * @param supplierId - product's supplier identifier
	 */
	public void addProduct(Product prod2Add, Long supplierId);
	
	/**
	 * Method provides logic for retrieving all {#link Product}, which matches specified criteria.
	 * 
	 * @param name - name of the product
	 * @param quantity - quantity of the product
	 * @param supplierId - product's supplier identifier
	 */
	public List<Product> findProductsByName(String name, Integer quantity, Long supplierId);
	
	/**
	 * Method provides logic for retrieving all Product from data base.
	 */
	public List<Product> findAllProducts();
	
	/**
	 * Method provides logic for retrieving all Supplier from data base.
	 */
	public List<Supplier> findAllSuppliers();
	
	/**
	 * Method provides logic for updating Product state in data base.
	 * 
	 * @param object2Update - object to update
	 */
	public void update(Product prod);
	
	/**
	 * Method provides logic for retrieving objects by id.
	 * 
	 * @param clazz - type of the object
	 * @param id - identifier of the object
	 */
	public <T extends BaseModel> T getObjectById(Class<T> clazz, Long id);
}
