package client.ch10;

import java.util.HashSet;
import java.util.Set;

import javax.jms.Connection;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;

import client.ctx.provider.ServiceLocator;
import core.ejb.logic.travelagent.TravelAgentRemote;
import core.ejb.model.Address;
import core.ejb.model.CreditCard;
import core.ejb.model.Customer;
import core.ejb.model.Reservation;

public class Client_1 {
    public static void main(String[] args) {
	try {
	    TravelAgentRemote travelAgent = ServiceLocator.getInstance()
		    .getTravelAgent();

	    // initDB();

	    // travelAgent.removeAndMerge();
	    // travelAgent.merge();
	    // travelAgent.close();
	    // travelAgent.getCustRef(1111l);
	    // String query =
	    // "select c.lastName, count(res), sum(res.totalPaid) from Customer c left join c.reservations res group by c.lastName having sum(res.totalPaid) > 2 order by c.lastName desc";

	    /*
	     * String query =
	     * "select c.CUST_ID, c.FIRST_NAME, c.LAST_NAME, c.city, c.houseNo, c.street, c.card_id, cc_id from CUSTOMER c, CreditCard cc where cc.cc_id = c.card_id"
	     * ; //left join reservation r on r.cust_id = c.cust_id group by
	     * c.cust_id"; List<?> result =
	     * travelAgent.executeNativeQuery(query, "customerMapping");//
	     * travelAgent.executeQuery(query);
	     * 
	     * System.out.println(result);
	     */
	    travelAgent.testMessaging();
	    sendMessage();

	} catch (Exception ne) {
	    ne.printStackTrace();
	}
    }

    private static void sendMessage() throws Exception {

	QueueConnectionFactory jmsConnFactory = ServiceLocator.getInstance()
		.getConnectionFactory();
	Queue sl2MdbQueue = ServiceLocator.getInstance().getSl2MdbQueue();

	Connection conn = jmsConnFactory.createConnection();
	javax.jms.Session session = conn.createSession(false,
		Session.AUTO_ACKNOWLEDGE);
	javax.jms.MessageProducer producer = session
		.createProducer(sl2MdbQueue);
	TextMessage msg = session.createTextMessage("Client to MDB");
	msg.setStringProperty("type", "type2");
	producer.send(msg);

	conn.close();
    }

    @SuppressWarnings("unused")
    private static void initDB() throws Exception {

	TravelAgentRemote travelAgent = ServiceLocator.getInstance()
		.getTravelAgent();

	for (int i = 0; i < 15; i++) {
	    Set<Reservation> res = new HashSet<Reservation>();
	    for (int j = 0; j < 3; j++) {
		res.add(new Reservation(j));
	    }
	    travelAgent.persistEntity(new Customer("firstName - " + i,
		    "lastName - " + i, new Address("city - " + i, "street - "
			    + i, i), res, new CreditCard(i)));
	}
    }
}
