package core.ejb.logic.travelagent;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import core.ejb.model.Cabin;

@Stateful
public class ExtendedPersistenceContextBean implements ExtendedPersistenceContextRemote
{
    @PersistenceContext(unitName="titan", type=PersistenceContextType.EXTENDED)
    private EntityManager manager;

    private Cabin cabin;

    public void setCabin(long pk)
    {
	cabin = manager.find(Cabin.class, pk);
    }

    public void updateBedCount(int newBedCount)
    {
	cabin.setBedCount(newBedCount);
    }

    @Remove
    public void remove()
    {
    }
}
