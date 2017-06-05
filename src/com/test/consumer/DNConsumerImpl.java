package com.test.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class DNConsumerImpl  implements DNConsumer{

	
	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER;	
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;	
	private static final String BROKURL=ActiveMQConnection.DEFAULT_BROKER_URL;	
	ConnectionFactory connectionFactory;	
	Connection  connection;	
	Session     session;
	
	public void init() {
		connectionFactory=new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKURL);
		
		try {
			connection=connectionFactory.createConnection();
			
			connection.start();
			
			session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);//���Զ��ύ���ֶ��ύ
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	public void getMessage(String disname) {
		try {
			Queue queue=session.createQueue(disname);
			
			MessageConsumer messageConsumer=session.createConsumer(queue);
			
			while(true){
				
				TextMessage message=(TextMessage) messageConsumer.receive();
				
				message.acknowledge();//��������Ӧ��
				
				Thread.sleep(1000);
				
				if(message!=null){
					System.out.println("consumer�����������ߣ��ҽ��յ������ݣ�"
									+message.getText());
				}else{
					break;
				}
			}
			
			
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
