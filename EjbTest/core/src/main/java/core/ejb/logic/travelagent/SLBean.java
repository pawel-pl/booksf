package core.ejb.logic.travelagent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import core.ejb.model.Model;

@Stateless
public class SLBean implements SLInter{

    @PersistenceContext(unitName="titan")
    private EntityManager manager;

    @Override
    public <T> T findById(Class<T> clazz, int id) {
	
	System.out.println("Delegate: "+manager.getDelegate());
	
	Model m = (Model)manager.find(clazz, id);
	System.out.println(m == null ? "null" : m.getId());
	
	return null;
    }
    
}
