package client.ch5;

import client.ctx.provider.ServiceLocator;
import core.ejb.logic.travelagent.TravelAgentRemote;
import core.ejb.model.Cabin;

public class Client_1 {
	public static void main(String[] args) {
		try {
			
			TravelAgentRemote travelAgent = ServiceLocator.getInstance()
					.getTravelAgent();

			Cabin noCabin = travelAgent.findCabin(1);
			System.out.println("no cabin should be null: " + noCabin);

			Cabin cabin_1 = new Cabin();
			cabin_1.setName("Master Suite");
			cabin_1.setDeckLevel(1);
			cabin_1.setShipId(1);
			cabin_1.setBedCount(3);

			travelAgent.createCabin(cabin_1);

			Cabin cabin_2 = travelAgent.findCabin(1);
			System.out.println(cabin_2.getName());
			System.out.println(cabin_2.getDeckLevel());
			System.out.println(cabin_2.getShipId());
			System.out.println(cabin_2.getBedCount());

			System.out
					.println("Updating detached cabin instance with new bed count of 4");
			cabin_2.setBedCount(4);
			travelAgent.updateCabin(cabin_2);

			System.out
					.println("Finding cabin to see it has been updated with a merge() on server");
			Cabin cabin_3 = travelAgent.findCabin(1);
			System.out.println("new bed count is: " + cabin_3.getBedCount());
		} catch (Exception ne) {
			ne.printStackTrace();
		}
	}

}
