package ejb.bean;

import java.util.List;

import core.ejb.model.Product;

/**
 * 
 * JSF managed bean which provides logic for editing and removing product
 *
 */
public class EditOrRemoveBean extends BaseBean implements Cleanable{
	
	private Long productId;
	
	private Product productToEdit;
	
	public void delete(){
	
		productService.deleteProduct(productId);
		clean();
	}
	
	public void edit(){
		
		productService.update(productToEdit);
		clean();
	}
	
	public Product getProductToEdit() {
		
		if(productToEdit != null ){
			return productToEdit;
		}
		if(productId != null){
			productToEdit = productService.getObjectById(Product.class, productId);
		}
		
		return productToEdit;
	}
	
	public List<Product> getAllProducts(){
		products = productService.findAllProducts();
		return products;
	}
	
	public Long getProductId() {
		return productId;
	}

	public void setProductToEdit(Product productToEdit) {
		this.productToEdit = productToEdit;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public void clean() {
		
		suppliers = null;
		products = null;
		productToEdit = null;
		productId = null;
	}
}
