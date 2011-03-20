package core.ejb.logic.travelagent;

import javax.ejb.Remote;

@Remote
public interface ExtendedPersistenceContextRemote
{
    public void setCabin(long pk);
    public void updateBedCount(int newBedCount);
    public void remove();
}
