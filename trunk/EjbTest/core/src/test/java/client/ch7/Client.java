package client.ch7;

import client.ctx.provider.ServiceLocator;
import core.ejb.logic.travelagent.TravelAgentRemote;

public class Client {
	public static void main(String[] args) {
		try {
			TravelAgentRemote travelAgent = ServiceLocator.getInstance()
					.getTravelAgent();

			travelAgent.testRelationship();
			travelAgent.printComponents();
			
		} catch (Exception ne) {
			ne.printStackTrace();
		}
	}

}
