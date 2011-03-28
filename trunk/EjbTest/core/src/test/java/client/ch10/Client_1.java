package client.ch10;

import java.util.HashSet;
import java.util.Set;

import javax.jms.Connection;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;

import client.ctx.provider.ServiceLocator;
import core.ejb.logic.travelagent.BMTBeanRemote;
import core.ejb.logic.travelagent.StatefulBeanRemote;
import core.ejb.logic.travelagent.TestBeanRemote;
import core.ejb.logic.travelagent.TravelAgentRemote;
import core.ejb.model.Address;
import core.ejb.model.Book;
import core.ejb.model.CreditCard;
import core.ejb.model.Customer;
import core.ejb.model.Model;
import core.ejb.model.ModelId;
import core.ejb.model.Reader;
import core.ejb.model.Reservation;

public class Client_1 {
    public static void main(String[] args) {
	try {
	    /*
	     * TravelAgentRemote travelAgent = ServiceLocator.getInstance()
	     * .getTravelAgent();
	     */

	    TestBeanRemote testBean = ServiceLocator.getInstance().getTestBean();
	    StatefulBeanRemote sfBean = ServiceLocator.getInstance().getStatefulBean();
	    BMTBeanRemote bmtBean = ServiceLocator.getInstance().getBMTBean();
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
	    // travelAgent.testMessaging();
	    // sendMessage();
	    // travelAgent.persistModel(1);
	    
	    //addReadersToDB();
	    String query="select r from Book b inner join b.reader r";
	    testBean.executeJpaQuery(query);
	    //testBean.compareReferances();
	    //testBean.mandatoryTransaction();
	    //testBean.exceptionTest();
	    //sfBean.noTransactionMethod();
	    //testBean.notSupportedTransaction();
	    //bmtBean.methodWithUserTx();
	    //testBean.exceptionWithoutTransactionPropagationTest();
	    //testBean.exceptionWithTransactionPropagationTest();
	    //findModelById(testBean, 1);
	    

	} catch (Exception ne) {
	    ne.printStackTrace();
	}
    }

    private static void findModelById(TestBeanRemote testBean, int id){
	
	    testBean.persist(new Model(1));
	    Model m = testBean.find(Model.class, new ModelId(1));
	    System.out.println(m);
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

    private static void addReadersToDB() throws Exception {

	TravelAgentRemote travelAgent = ServiceLocator.getInstance()
		.getTravelAgent();

	for (int i = 0; i < 2; i++) {
	    Set<Book> books = new HashSet<Book>();
	    for (int j = 0; j < 2; j++) {
		books.add(new Book("title " + j));
	    }
	    travelAgent.persistEntity(new Reader(i, books));
	}
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
