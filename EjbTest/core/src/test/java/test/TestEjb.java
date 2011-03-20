package test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;

import core.ejb.logic.travelagent.TravelAgentRemote;
import core.ejb.model.Cabin;

public class TestEjb {

	//EjbTest/TravelAgentBean/remote
	public static final String TRAVEL_AGENT_NAME = "EjbTest/TravelAgentBean/remote";
	
	public static void main(String[] args) throws Exception{
		
		InitialContext ctx = getContext();
		TravelAgentRemote ta = (TravelAgentRemote)lookup(ctx, TRAVEL_AGENT_NAME);
		ta.createCabin(createCabin());
		Cabin foundCabin = ta.findCabin(1);
		System.out.println(foundCabin);
        System.out.println("end");
	}
	
	private static Cabin createCabin(){
		
		return new Cabin(1l,"cabin_1", 1, 1, 1);
	}
	
	public static Object lookup(InitialContext ctx, String beanName) throws Exception {
		
		return ctx.lookup(beanName);
	}
	
	public static void list(InitialContext ctx) throws Exception{
        
		NamingEnumeration<NameClassPair> names = ctx.list("EjbTest/TravelAgentBean/remote");
        while(names.hasMoreElements()){
        	NameClassPair cp = names.next();
        	System.out.println(cp.getClassName()+", "+cp.getName());
        }
	}
	private static InitialContext getContext() throws Exception{
		
		Hashtable<String, String> environment = new Hashtable<String, String>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        environment.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        environment.put(Context.PROVIDER_URL, "jnp://localhost:1099"); // remote machine IP
        
        return new InitialContext(environment);
	}
}
