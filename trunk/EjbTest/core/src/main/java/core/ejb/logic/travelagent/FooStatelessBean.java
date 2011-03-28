package core.ejb.logic.travelagent;

import javax.ejb.Stateless;

@Stateless
public class FooStatelessBean implements FooStateless {

    public void inPostConstruct() {
	
	System.out.println("InPostConstruct");
    }
    
    public void throwException() {
	
	if(true){
	    throw new IllegalStateException("propagated exception");
	}
    }
}
