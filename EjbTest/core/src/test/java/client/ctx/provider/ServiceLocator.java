package client.ctx.provider;

import java.util.Hashtable;

import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;

import core.ejb.logic.travelagent.ExtendedPersistenceContextRemote;
import core.ejb.logic.travelagent.TestBeanRemote;
import core.ejb.logic.travelagent.TransactionPersistenceContextRemote;
import core.ejb.logic.travelagent.TravelAgentRemote;

public class ServiceLocator {

	private static ServiceLocator sl;
	
	private InitialContext ctx;
	
	private ServiceLocator(){
		try {
			ctx = getContext();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ServiceLocator getInstance() {
		
		if(sl == null){
			System.out.println("Init service locator");
			sl = new ServiceLocator();
		}
		
		return sl;
	}
	
	public static final String CONNECTION_FACTORY = "ConnectionFactory";
	public static final String sl2MdbQueue = "/queue/sl2mdb";
	public static final String TRAVEL_AGENT_NAME = "EjbTest/TravelAgentBean/remote";
	public static final String TEST_BEAN_NAME = "EjbTest/TestBean/remote";
	public static final String TX_TRAVEL_AGENT_NAME = "EjbTest/TransactionPersistenceContextBean/remote";
	public static final String EX_TRAVEL_AGENT_NAME = "EjbTest/ExtendedPersistenceContextBean/remote";
	
	public TravelAgentRemote getTravelAgent() throws Exception {
		
		return (TravelAgentRemote)lookup(TRAVEL_AGENT_NAME);
	}
	
	public TestBeanRemote getTestBean() throws Exception {
		
		return (TestBeanRemote)lookup(TEST_BEAN_NAME);
	}
	
	public TransactionPersistenceContextRemote getTxTravelAgent() throws Exception {
		
		return (TransactionPersistenceContextRemote)lookup(TX_TRAVEL_AGENT_NAME);
	}
	
	public ExtendedPersistenceContextRemote getExTravelAgent() throws Exception {
		
		return (ExtendedPersistenceContextRemote)lookup(EX_TRAVEL_AGENT_NAME);
	}
	
	private Object lookup(String beanName) throws Exception {
		
		return ctx.lookup(beanName);
	}
	
	public QueueConnectionFactory getConnectionFactory() throws Exception {
		
		return (QueueConnectionFactory)lookup(CONNECTION_FACTORY);
	}
	
	public Queue getSl2MdbQueue() throws Exception {
		
		return (Queue)lookup(sl2MdbQueue);
	}
	
	private static InitialContext getContext() throws Exception{
		
		Hashtable<String, String> environment = new Hashtable<String, String>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        environment.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        environment.put(Context.PROVIDER_URL, "jnp://localhost:1099");
        
        return new InitialContext(environment);
	}
}
