package core.ejb.logic.travelagent;

import javax.ejb.Local;

@Local
public interface FooStateless {

    public void inPostConstruct();
    
    public void throwException();
}
