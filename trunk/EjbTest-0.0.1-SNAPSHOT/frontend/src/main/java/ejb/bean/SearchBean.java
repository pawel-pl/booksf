package ejb.bean;

import java.util.List;

import core.ejb.model.Product;
import ejb.bean.dto.SearchDataDTO;

/**
 * JSF managed bean which provides logic for searching product
 *
 */
public class SearchBean extends BaseBean {
	
	private SearchDataDTO searchDTO;
	
	public void search(){
		
		if(searchDTO == null){
			throw new IllegalStateException("Search DTO can not be null");
		}
		
		products = productService.findProductsByName
			(searchDTO.getName(), searchDTO.getQuantity(), searchDTO.getSupplier());
	}

	public SearchDataDTO getSearchDTO() {
		if(searchDTO == null){
			searchDTO = new SearchDataDTO();
		}
		return searchDTO;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void setSearchDTO(SearchDataDTO searchDTO) {
		this.searchDTO = searchDTO;
	}
	
}
