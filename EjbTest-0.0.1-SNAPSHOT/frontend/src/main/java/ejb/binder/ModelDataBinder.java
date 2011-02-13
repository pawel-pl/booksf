package ejb.binder;

import core.ejb.model.Product;
import ejb.bean.dto.AddProductDTO;

/**
 * Object provides methods to bind data between DTO and model objects. 
 *
 */
public class ModelDataBinder {

	public static Product bindProduct(AddProductDTO dto){
		
		Product product = new Product();
		
		product.setDescription(dto.getDescription());
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		product.setQuantity(dto.getQuantity());
		
		return product;
	}
}
