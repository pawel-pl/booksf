package core.ejb.logic.travelagent;

import javax.ejb.Remote;

@Remote
public interface TestBeanRemote {

    public void mandatoryTransaction();
    
    public void executeJpaQuery(String query);
    
    public void compareReferances();
}
