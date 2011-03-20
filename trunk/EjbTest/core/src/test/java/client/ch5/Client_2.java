package client.ch5;

import javax.naming.Context;

import client.ctx.provider.ServiceLocator;

import core.ejb.logic.travelagent.ExtendedPersistenceContextRemote;
import core.ejb.logic.travelagent.TransactionPersistenceContextRemote;
import core.ejb.logic.travelagent.TravelAgentRemote;
import core.ejb.model.Cabin;

public class Client_2 {
	public static void main(String[] args) {
		try {
			ServiceLocator sl = ServiceLocator.getInstance();
			TravelAgentRemote travelAgent = sl.getTravelAgent();
			TransactionPersistenceContextRemote txBean = sl.getTxTravelAgent();
			ExtendedPersistenceContextRemote extendedBean = sl.getExTravelAgent();
			travelAgent.flushModeExample();
			//txBean.findAllCabins();
/*			Cabin fetchedCabin = travelAgent.findCabin(1);
			int oldBedCount = fetchedCabin.getBedCount();
			int newBedCount = oldBedCount == 4 ? 5 : 4;
			System.out.println("Updating using transaction manager.");
			txBean.setCabin(1);
			txBean.updateBedCount(newBedCount);
			fetchedCabin = travelAgent.findCabin(1);
			System.out.println("Cabin bed count will still be " + oldBedCount+": " + fetchedCabin.getBedCount());
			
			System.out.println("Updated using extended manager.");
			extendedBean.setCabin(1);
			extendedBean.updateBedCount(newBedCount);
			fetchedCabin = travelAgent.findCabin(1);
			System.out.println("Cabin bed count will be "+newBedCount+": "+ fetchedCabin.getBedCount());*/

			// cleanup
			txBean.remove();
			extendedBean.remove();
		} catch (Exception ne) {
			ne.printStackTrace();
		}
	}

	public static Context getInitialContext()
			throws javax.naming.NamingException {
		return new javax.naming.InitialContext();
	}
}
