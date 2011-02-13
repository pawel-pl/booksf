package ejb.bean;

import java.util.List;

import javax.ejb.EJB;

import core.ejb.logic.service.ProductService;
import core.ejb.model.Product;

public class JsfManagedBean {
	
	@EJB
	private ProductService productService;
	
	private List<Product> products;
	
	public void printABC() {
		
		System.out.println("Calling print from mgn bean");
		
	}
	
	public List<Product> getProducts() {
		products = productService.findAllProducts();
		return products;
	}
	
}
