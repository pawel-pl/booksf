package core.ejb.logic.travelagent;

import javax.ejb.Remote;

@Remote
public interface TransactionPersistenceContextRemote
{
    public void setCabin(long pk);
    public void updateBedCount(int newBedCount);
    public void remove();
    public void findAllCabins();
}
