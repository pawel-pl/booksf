package core.ejb.logic.travelagent;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TestBean implements TestBeanRemote {

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

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void mandatoryTransaction() {

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
