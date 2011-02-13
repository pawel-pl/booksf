package ejb.bean;

import ejb.hepler.Constants;

/**
 * 
 * JSF managed bean which is used to navigation between views
 *
 */
public class MenuBean extends BaseBean {
	
	public boolean getIsInFailuerState(){
		System.out.println("IsInFailuerState 2");
		boolean b = true;
		return b;
	}
	public String showAllProducts(){
		
		return Constants.VIEWS.SHOW_ALL_PRODUCTS;
	}
	
	public String search(){
		
		return Constants.VIEWS.SEARCH;
	}
	
	public String addProduct(){
		
		return Constants.VIEWS.ADD_PRODUCT;
	}
}
