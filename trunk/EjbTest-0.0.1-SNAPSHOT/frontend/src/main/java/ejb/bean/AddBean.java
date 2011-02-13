package ejb.bean;

import ejb.bean.dto.AddProductDTO;
import ejb.binder.ModelDataBinder;

/**
 * 
 * JSF managed bean which provides logic for adding product
 *
 */
public class AddBean extends BaseBean {

	private AddProductDTO addProductDTO;

	public void addProduct(){
		
		if(addProductDTO == null){
			throw new IllegalArgumentException("Dto can not be null");
		}
		
		productService.addProduct(ModelDataBinder.bindProduct(addProductDTO),
				addProductDTO.getSupplier());
	}
	
	public AddProductDTO getAddProductDTO() {
		
		if(addProductDTO == null){
			addProductDTO = new AddProductDTO();
		}
		
		return addProductDTO;
	}

	public void setAddProductDTO(AddProductDTO addProductDTO) {
		this.addProductDTO = addProductDTO;
	}
}
