package core.ejb.logic.travelagent;

import java.util.List;

import javax.ejb.Remote;

import core.ejb.model.Cabin;
import core.ejb.model.Customer;

@Remote
public interface TravelAgentRemote {

    public void persistModel(int id);
    
    public void testMessaging();
    
    public void removeAndMerge();
    
    public void merge();
    
    public void close();
    
    public void getCustRef(long id);
    
    public List<?> executeQuery(String query);

    public List<?> executeNativeQuery(String query, Class<?> resultClass);

    public List<?> executeNativeQuery(String query, String mappingName);

    public void persistEntity(Object entity);

    public void testInheritance();

    public void createCabin(Cabin cabin);

    public Cabin findCabin(long pKey);

    public void updateCabin(Cabin cabin);

    public void flushModeExample();

    public long createCustomer(Customer cust);

    public Customer findCustomer(long pk);

    public Customer findCustomer(int pKey);

    public Customer findCustomer(String lastName, long ssn);

    public void testRelationship();

    public void printComponents();
}
