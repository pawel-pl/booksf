package client.ch6._4;

import javax.naming.Context;

import client.ctx.provider.ServiceLocator;

import core.ejb.logic.travelagent.TravelAgentRemote;
import core.ejb.model.Customer;

public class Client {
	public static void main(String[] args) {
		try {
			TravelAgentRemote travelAgent = ServiceLocator.getInstance()
					.getTravelAgent();

			Customer cust = new Customer();
			cust.setFirstName("Bill");
			cust.setLastName("Burke");
			//cust.setStreet("Clarendon Street");
			//cust.setCity("Boston");
			//cust.setState("MA");

			long pk = travelAgent.createCustomer(cust);

			cust = travelAgent.findCustomer(pk);
			System.out.println(cust.getFirstName());
			System.out.println(cust.getLastName());
			//System.out.println(cust.getStreet());
			//System.out.println(cust.getCity());
			//System.out.println(cust.getState());
		} catch (Exception ne) {
			ne.printStackTrace();
		}
	}

	public static Context getInitialContext()
			throws javax.naming.NamingException {
		return new javax.naming.InitialContext();
	}
}
