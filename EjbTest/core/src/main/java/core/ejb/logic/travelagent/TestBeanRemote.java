package core.ejb.logic.travelagent;

import javax.ejb.Remote;

@Remote
public interface TestBeanRemote {

    public <T> T find(Class<T> clazz, Object id);
    
    public void persist(Object obj);
    
    public void exceptionWithoutTransactionPropagationTest();
    
    public void exceptionWithTransactionPropagationTest();
    
    public void notSupportedTransaction();
    
    public void requiresNewTransaction();
    
    public void exceptionTest() throws Exception;
    
    public void mandatoryTransaction();
    
    public void executeJpaQuery(String query);
    
    public void compareReferances();
}
