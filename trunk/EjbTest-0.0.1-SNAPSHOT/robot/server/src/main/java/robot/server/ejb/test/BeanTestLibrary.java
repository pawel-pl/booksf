package robot.server.ejb.test;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

import core.ejb.model.Product;

public class BeanTestLibrary {
	
	public static List<Product> findAllProducts() throws Exception{
		
		List<Product> prod = null;
		try{
			prod = ContextProvider.getInstance().getProductService().findAllProducts();
		}catch (UndeclaredThrowableException ex){

			throw new RuntimeException(ex.getUndeclaredThrowable());
		}
		
		return prod;
	}
	
}
