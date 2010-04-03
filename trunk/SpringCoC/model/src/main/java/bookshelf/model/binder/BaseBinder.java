package bookshelf.model.binder;

import java.util.Collection;
import java.util.Map;

public abstract class BaseBinder {

	public boolean isEmpty(Object obj){
		
		if(obj == null ||
			(obj instanceof String && ((String)obj).isEmpty()) || 
			(obj instanceof Collection<?> && ((Collection<?>)obj).isEmpty()) ||
			(obj instanceof Map<?,?> && ((Map<?,?>)obj).isEmpty())) {
			
			return true;
		}
		
		return false;
	}
}
