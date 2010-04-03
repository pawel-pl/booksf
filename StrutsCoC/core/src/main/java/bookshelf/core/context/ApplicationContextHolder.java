package bookshelf.core.context;

import org.springframework.context.ApplicationContext;

public class ApplicationContextHolder {
	
	private static ApplicationContextHolder inst;
	
	private ApplicationContext ctx;
	
	private ApplicationContextHolder(){
		
	}
	
	public static ApplicationContextHolder getInstance(){
		
		if(inst == null){
			throw new IllegalStateException("ApplicationContextHolder is not initialized");
		}
		
		return inst;
	}
	
	public static void initialize(ApplicationContext ctx){
		
		if(inst == null){
			inst = new ApplicationContextHolder();
		}
		
		inst.ctx = ctx;
	}

	@SuppressWarnings("unchecked")
	public  static <T> T getBean(String name, Class<T> clazz){
		return (T)inst.ctx.getBean(name);
	}
}
