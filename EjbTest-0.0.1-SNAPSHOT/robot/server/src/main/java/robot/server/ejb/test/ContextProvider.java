package robot.server.ejb.test;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import core.ejb.logic.service.ProductService;

public class ContextProvider {

	private static final String PRODUCT_SERVICE = "EjbTest/ProductServiceImpl/remote";
	private static ContextProvider instance;
	private static InitialContext ctx;
	
	private ContextProvider(){
		
	}
	
	public static ContextProvider getInstance() {
		
		if(instance == null){
			instance = new ContextProvider();
			init();
		}
		
		return instance;
	}
	
	private static void init(){
		
		Properties env = new Properties();
		
		env.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        env.put("java.naming.provider.url", "jnp://localhost:10990");
        
        try {
			ctx = new InitialContext(env);
		} catch (NamingException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public ProductService getProductService(){
		
		return lookup(ProductService.class, PRODUCT_SERVICE);
	}
	
	@SuppressWarnings("unchecked")
	private <T> T lookup(Class<T> clazz, String name){
		
		T obj = null;
		try {
			obj = (T)ctx.lookup(name);
		} catch (NamingException e) {
			throw new IllegalStateException(e);
		}
		
		return obj;
	}
}
