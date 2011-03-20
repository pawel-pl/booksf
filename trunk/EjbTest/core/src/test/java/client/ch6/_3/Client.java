package client.ch6._3;

import javax.naming.Context;

import client.ctx.provider.ServiceLocator;

import core.ejb.logic.travelagent.TravelAgentRemote;
import core.ejb.model.Customer;
import core.ejb.model.CustomerPK;

public class Client {
	public static void main(String[] args) {
		try {
			TravelAgentRemote travelAgent = ServiceLocator.getInstance()
					.getTravelAgent();

			CustomerPK pk = new CustomerPK("Burke", 9999999);
			Customer cust = new Customer();
			//cust.setPk(pk);
			cust.setFirstName("Bill");

			travelAgent.createCustomer(cust);

			cust = travelAgent.findCustomer("Burke", 9999999);
			System.out.println(cust.getFirstName());
			System.out.println(cust.getLastName());
			//System.out.println(cust.getSsn());
		} catch (Exception ne) {
			ne.printStackTrace();
		}
	}

	public static Context getInitialContext()
			throws javax.naming.NamingException {
		return new javax.naming.InitialContext();
	}
}
