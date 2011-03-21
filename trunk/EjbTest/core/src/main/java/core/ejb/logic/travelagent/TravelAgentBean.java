package core.ejb.logic.travelagent;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import core.ejb.model.Animal;
import core.ejb.model.Boxer;
import core.ejb.model.Cabin;
import core.ejb.model.Component;
import core.ejb.model.ComponentParam;
import core.ejb.model.Customer;
import core.ejb.model.CustomerPK;
import core.ejb.model.Dog;

@Stateful
public class TravelAgentBean implements TravelAgentRemote {

    @PersistenceUnit(unitName = "titan")
    private EntityManagerFactory factory;
    private EntityManager mgm;
    @PersistenceContext(unitName = "titan")
    private EntityManager manager;
    private Customer cust = null;

    @Resource(mappedName = "java:/JmsXA")
    private QueueConnectionFactory jmsConnFactory;

    @Resource(mappedName = "/queue/sl2mdb")
    private Queue sl2MdbQueue;

    @Resource(mappedName = "queue/mdb2mdb")
    private Queue mdb2MdbQueue;

    public void testMessaging() {

	System.out.println("Test Messaging");
	Connection conn = null;
	try {
	    conn = jmsConnFactory.createConnection();
	    javax.jms.Session session = conn.createSession(true,
		    Session.SESSION_TRANSACTED);
	    javax.jms.MessageProducer producer = session
		    .createProducer(sl2MdbQueue);
	    TextMessage msg = session.createTextMessage("Stateless to MDB");
	    msg.setStringProperty("type", "type1");
	    msg.setJMSReplyTo(mdb2MdbQueue);
	    producer.send(msg);
	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    if (conn != null) {
		try {
		    conn.close();
		} catch (JMSException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

    public void removeAndMerge() {

	try {
	    mgm = factory.createEntityManager();
	    cust = mgm.find(Customer.class, 1l);
	    mgm.remove(cust);
	    // mgm.merge(cust);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    public void merge() {

	mgm.joinTransaction();
	mgm.clear();
	mgm.merge(cust);
    }

    public void close() {

	mgm.close();
    }

    public void persistEntity(Object entity) {

	manager.persist(entity);
    }

    public List<?> executeQuery(String query) {

	return manager.createQuery(query).getResultList();
    }

    public List<?> executeNativeQuery(String query, Class<?> resultClass) {

	return manager.createNativeQuery(query, resultClass).getResultList();
    }

    public List<?> executeNativeQuery(String query, String mappingName) {

	System.out.println("Executing query: " + query);
	return manager.createNativeQuery(query, mappingName).getResultList();
    }

    @Override
    public void testInheritance() {

	Animal animal = new Animal("animal");

	Dog dog = new Dog(4);
	dog.setName("dog");

	Boxer boxer = new Boxer("sand");
	boxer.setName("boxer");
	boxer.setNoOfLegs(4);

	manager.persist(animal);
	manager.persist(dog);
	manager.persist(boxer);
    }

    @Override
    public void testRelationship() {

	try {
	    Component comp1 = new Component("comp1");
	    /*
	     * ComponentParam param1 = new ComponentParam("param1");
	     * comp1.setParam(param1);
	     */
	    manager.persist(comp1);

	    Component comp2 = new Component("comp2");
	    ComponentParam param2 = new ComponentParam("param2");
	    comp2.setParam(param2);
	    manager.persist(comp2);

	    // manager.remove(param2);
	    // comp2.setParam(null);
	    // manager.flush();
	    // comp1.setParam(param2);
	    // param2.setId(comp2.getId());
	    // manager.persist(param2);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    public void printComponents() {
	@SuppressWarnings("unchecked")
	List<Component> comps = (List<Component>) manager.createQuery(
		"from Component").getResultList();
	System.out.println(comps);
    }

    public void getCustRef(long id) {

	Customer cust = manager.getReference(Customer.class, id);
	System.out.println();
	cust.getFirstName();
	System.out.println();
    }

    public long createCustomer(Customer cust) {
	manager.persist(cust);
	return cust.getId();
    }

    public Customer findCustomer(long pk) {
	return manager.find(Customer.class, pk);
    }

    public Customer findCustomer(int pKey) {
	return manager.find(Customer.class, pKey);
    }

    public Customer findCustomer(String lastName, long ssn) {
	CustomerPK pk = new CustomerPK(lastName, ssn);
	return manager.find(Customer.class, pk);
    }

    public void createCabin(Cabin cabin) {
	manager.persist(cabin);
    }

    public Cabin findCabin(long pKey) {
	return manager.find(Cabin.class, pKey);
    }

    public void updateCabin(Cabin cabin) {
	manager.merge(cabin);
    }

    public void flushModeExample() {
	EntityManager createdManager = factory.createEntityManager();

	try {
	    Cabin newCabin2 = new Cabin(2l, "Other cabin", 2, 2, 2);
	    createdManager.persist(newCabin2);
	    // createdManager.flush();
	    Cabin cabin2 = createdManager.find(Cabin.class, 3l);
	    if (cabin2 != null) {
		throw new RuntimeException(
			"newCabin2 should not be flushed yet");
	    }

	    boolean withRealId = true;
	    // should be commit
	    if (withRealId) {
		manager.createQuery("FROM Cabin c WHERE c.id = 1")
			.getSingleResult();
	    } else {
		createdManager.createQuery("FROM Cabin c WHERE c.id = 15");
	    }

	    cabin2 = manager.find(Cabin.class, 2l);
	    if (cabin2 == null) {
		// throw new
		// RuntimeException("newCabin2 should be flushed now");
	    }

	    // createdManager.setFlushMode(FlushModeType.COMMIT);
	    newCabin2.setBedCount(99);

	    // should be commit
	    try {
		createdManager.createQuery("FROM Cabin c WHERE c.id = 15")
			.getSingleResult();
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
	    manager.refresh(cabin2);
	    if (cabin2.getBedCount() == 99) {
		throw new RuntimeException(
			"should not be 99 yet with COMMIT and a query");
	    }

	    createdManager.flush();

	    manager.refresh(cabin2);
	    if (cabin2.getBedCount() != 99) {
		throw new RuntimeException("should be 99 yet with a flush");
	    }
	} finally {
	    createdManager.close();
	}
    }
}
