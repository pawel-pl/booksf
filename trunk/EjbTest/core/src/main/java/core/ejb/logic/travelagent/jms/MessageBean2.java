package core.ejb.logic.travelagent.jms;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
	@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
	@ActivationConfigProperty(propertyName = "destination", propertyValue = "/queue/mdb2mdb"),
	@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "type='type2'") })
public class MessageBean2 implements MessageListener {

    @Resource(mappedName = "java:/JmsXA")
    private QueueConnectionFactory jmsConnFactory;

    @Resource(mappedName = "queue/mdb2mdb")
    private Queue mdb2MdbQueue;

    @Override
    public void onMessage(Message msg) {

	TextMessage textMsg = (TextMessage) msg;
	Connection conn = null;
	try {
	    System.out.println("Msg in MessageBean2: " + textMsg.getText());
	    conn = jmsConnFactory.createConnection();
	    javax.jms.Session session = conn.createSession(true,
		    Session.SESSION_TRANSACTED);
	    javax.jms.MessageProducer producer = session.createProducer(msg
		    .getJMSReplyTo());

	    TextMessage replayMsg = session.createTextMessage("MDB2 to MDB1");
	    replayMsg.setStringProperty("type", "type1");
	    replayMsg.setJMSReplyTo(mdb2MdbQueue);
	    try {
		Thread.sleep(3000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    producer.send(replayMsg);
	} catch (JMSException e) {
	    e.printStackTrace();
	} finally {
	    if (conn != null) {
		try {
		    conn.close();
		} catch (JMSException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

}
