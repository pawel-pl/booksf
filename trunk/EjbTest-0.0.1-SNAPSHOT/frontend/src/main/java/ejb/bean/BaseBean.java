package ejb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import core.ejb.logic.service.ProductService;
import core.ejb.model.Product;
import core.ejb.model.Supplier;

/**
 * 
 * JSF managed bean which contains common logic for beans
 *
 */
public class BaseBean {

	@EJB
	protected ProductService productService;
	
	protected List<SelectItem> suppliers;
	
	protected List<Product> products;
	
	public List<SelectItem> getSuppliers() {
		
		List<Supplier> dbSuppliers = productService.findAllSuppliers();
		suppliers = new ArrayList<SelectItem>();
		for(Supplier sup : dbSuppliers){
			suppliers.add(new SelectItem(sup.getId(), sup.getDescription(),  sup.getDescription(), false, false));
		}
		
		return suppliers;
	}

	public void setSuppliers(List<SelectItem> suppliers) {
		this.suppliers = suppliers;
	}
}
