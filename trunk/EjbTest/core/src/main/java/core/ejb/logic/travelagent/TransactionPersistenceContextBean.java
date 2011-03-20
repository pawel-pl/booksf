package core.ejb.logic.travelagent;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;

import core.ejb.model.Cabin;

@Stateful
public class TransactionPersistenceContextBean implements
		TransactionPersistenceContextRemote {

	@PersistenceUnit(unitName = "titan")
	private EntityManagerFactory factory;
	@PersistenceContext(unitName = "titan", type = PersistenceContextType.TRANSACTION)
	private EntityManager manager;
	private Cabin cabin;
	private EntityManager pcm;

	@PostConstruct
	public void initPCM() {

		System.out.println("Post construct");
		pcm = factory.createEntityManager();

	}

	public void setCabin(long pk) {
		cabin = manager.find(Cabin.class, pk);
	}

	public void updateBedCount(int newBedCount) {

		Cabin c = manager.merge(cabin);
		c.setBedCount(newBedCount);
	}

	@SuppressWarnings("unchecked")
	public void findAllCabins() {
		try {
			// pcm.joinTransaction();
			pcm = factory.createEntityManager();
			List<Cabin> allCabins = pcm.createQuery("from Cabin")
					.getResultList();
			int count = 0;
			if (allCabins != null && !allCabins.isEmpty()) {
				count = allCabins.size();
			}
			System.out.println("Old count: " + count);
			pcm.persist(new Cabin(1l,"new", 2, 2, 2));
			allCabins = manager.createQuery("from Cabin").getResultList();
			if (allCabins != null && !allCabins.isEmpty()) {
				count = allCabins.size();
			}
			System.out.println("New count: " + count);
		} finally {
			pcm.close();
		}
	}

	@Remove
	public void remove() {
	}
}
