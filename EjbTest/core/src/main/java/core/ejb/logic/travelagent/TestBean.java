package core.ejb.logic.travelagent;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import core.ejb.logic.travelagent.exception.AppException;
import core.ejb.model.Book;
import core.ejb.model.Model;

@Stateless
public class TestBean implements TestBeanRemote {

    @Resource
    private EJBContext ctx;
    
    @PersistenceContext(unitName = "titan")
    private EntityManager em;

    @EJB
    private FooStateless fooStateless1;

    @EJB
    private FooStateless fooStateless2;

    @EJB
    private FooStateful fooStateful1;

    @EJB
    private FooStateful fooStateful2;

    @SuppressWarnings("unused")
    @PostConstruct
    private void postConst(){
	
	System.out.println("PostConstruct");
	fooStateless1.inPostConstruct();
    }    
    
    public <T> T find(Class<T> clazz, Object id){
	
	return em.find(clazz, id);
    }
    
    public void persist(Object obj) {
	
	em.persist(obj);
    }
    
    public void exceptionTest() throws Exception {
	
	em.persist(new Book("title"));
	if(true){
	    throw new AppException("app exception text");
	}
    }
    
    public void exceptionWithoutTransactionPropagationTest(){
	
	if(true){
	    throw new IllegalStateException("exception without propagation");
	}
    }
    
    public void exceptionWithTransactionPropagationTest(){
	
	fooStateless1.throwException();
    }
    
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void mandatoryTransaction() {

    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void requiresNewTransaction() {
	
	System.out.println("REQUIRES_NEW");
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void notSupportedTransaction() {
	
	System.out.println("NOT_SUPPORTED");
	ctx.setRollbackOnly();
	System.out.println("END NOT_SUPPORTED");
    }

    public void executeJpaQuery(String query) {

	List<?> list = em.createQuery(query).getResultList();

	System.out.println(list);
    }

    public void compareReferances() {

	System.out.println("Stateless");
	System.out.println("fooStateless1.equals(fooStateless1) "
		+ fooStateless1.equals(fooStateless1));
	System.out.println("fooStateless1.equals(fooStateless2) "
		+ fooStateless1.equals(fooStateless2));

	System.out.println("Stateful");
	System.out.println("fooStateful1.equals(fooStateful1) "
		+ fooStateful1.equals(fooStateful1));
	System.out.println("fooStateful1.equals(fooStateful2) "
		+ fooStateful1.equals(fooStateful2));
    }
}
