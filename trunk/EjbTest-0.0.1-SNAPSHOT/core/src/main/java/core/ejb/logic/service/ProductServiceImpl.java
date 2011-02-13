package core.ejb.logic.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import core.ejb.logic.dao.ProductDao;
import core.ejb.model.BaseModel;
import core.ejb.model.Product;
import core.ejb.model.Supplier;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProductServiceImpl implements ProductService, Serializable {

	private static final long serialVersionUID = -2192119312806642993L;

	@EJB
	private ProductDao productDao;
	
	/**
	 * @see core.ejb.logic.service.ProductService#addProduct(Product, Long)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addProduct(Product prod2Add, Long supplierId) {
		
		if(prod2Add == null || supplierId == null){
			throw new IllegalArgumentException("Product and supplier ids can not be null");
		}
		
		Supplier sup = getObjectById(Supplier.class, supplierId);
		if(sup == null){
			throw new IllegalStateException("Supplier with id: "+supplierId+" was not found");
		}
		
		sup.addProduct(prod2Add);
		productDao.save(sup);
	}
	
	/**
	 * @see core.ejb.logic.service.ProductService#deleteProduct(Long)
	 */
	public void deleteProduct(Long productId) {
		
		if(productId == null) {
			throw new IllegalArgumentException("Product id can not be null");
		}
		
		Product prod = getObjectById(Product.class, productId);
		if(prod == null){
			throw new IllegalStateException("Product with id: "+productId+" was not found");
		}
		
		prod.getSupplier().removeProduct(prod);
		productDao.delete(prod);
		System.out.println("Product with id: "+productId+" was deleted");
	}
	
	/**
	 * @see core.ejb.logic.service.ProductService#findProductsByName(String, Integer, Long)
	 */
	public List<Product> findProductsByName(String name, Integer quantity, Long supplierId){
		
		if(name == null || quantity == null){
			throw new IllegalArgumentException("Name and quntity can not be null");
		}
		
		return productDao.findProductsByName(name, quantity, supplierId);
	}
	
	/**
	 * @see core.ejb.logic.service.ProductService#update(Product)
	 */
	public void update(Product prod){
		
		if(prod == null){
			throw new IllegalArgumentException("Product can not be null");
		}
		
		productDao.update(prod);
	}
	
	/**
	 * @see core.ejb.logic.service.ProductService#getObjectById(Class, Long)
	 */
	public <T extends BaseModel> T getObjectById(Class<T> clazz, Long id) {
		
		if(id == null){
			throw new IllegalArgumentException("Id can not be null");
		}
		
		return productDao.getObjectById(clazz, id);
	}
	
	/**
	 * @see core.ejb.logic.service.ProductService#findAllProducts()
	 */
	public List<Product> findAllProducts() {
		return productDao.findAllProducts();
	}
	
	/**
	 * @see core.ejb.logic.service.ProductService#findAllSuppliers()
	 */
	public List<Supplier> findAllSuppliers() {
		return productDao.findAllSuppliers();
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
}
