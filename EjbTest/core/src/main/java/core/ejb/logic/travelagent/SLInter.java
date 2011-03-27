package core.ejb.logic.travelagent;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface SLInter {
    
    public <T> T findById(Class<T> clazz, int id);
}
