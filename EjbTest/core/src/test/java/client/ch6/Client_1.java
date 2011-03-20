package client.ch6;

import client.ctx.provider.ServiceLocator;
import core.ejb.logic.travelagent.TravelAgentRemote;
import core.ejb.model.Customer;
import core.ejb.model.JPEG;

public class Client_1 {
	public static void main(String[] args) {
		try {
			
			TravelAgentRemote travelAgent = ServiceLocator.getInstance()
					.getTravelAgent();

            Customer cust = new Customer();
            cust.setFirstName("Bill");
           // cust.setLastName("Burke");
            //cust.setCustomerType(CustomerType.BIG_SPENDAH);
            
            JPEG oneUglyDude = new JPEG();
            //cust.setPicture(oneUglyDude);
            
            long pk = travelAgent.createCustomer(cust);

            cust = travelAgent.findCustomer(pk);
            System.out.println(cust.getFirstName());
            System.out.println(cust.getLastName());
            //System.out.println(cust.getCustomerType());
		} catch (Exception ne) {
			ne.printStackTrace();
		}
	}

}
