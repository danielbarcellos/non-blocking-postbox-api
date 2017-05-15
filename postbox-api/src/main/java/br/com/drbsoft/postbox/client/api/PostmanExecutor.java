package br.com.drbsoft.postbox.client.api;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.google.gson.GsonBuilder;
import com.rabbitmq.client.ConnectionFactory;
import br.com.drbsoft.rabbitmq.client.api.RabbitMQTemplate;
/**
 * Executa o envio de emails.
 * 
 * @author daniel
 *
 */
final class PostmanExecutor {

	private PostboxProperties properties;
	private RabbitMQTemplate rabbitTemplate;
	
	public PostmanExecutor(PostboxProperties properties) {
		this.properties = properties;
		this.rabbitTemplate = new RabbitMQTemplate(createConnectionFactory());
	}
	
	private ConnectionFactory createConnectionFactory() {
		if(this.properties == null){
			throw new IllegalArgumentException("Properties must not be null");
		}
		if(this.properties.getPort() == 0){
			this.properties.setPort(com.rabbitmq.client.ConnectionFactory.DEFAULT_AMQP_PORT);
		}
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(this.properties.getHost());
		factory.setPort(this.properties.getPort());
		
		return factory;
	}
	
	private void send(Content content) throws IOException, TimeoutException {
		this.rabbitTemplate.convertAndSend(this.properties.getExchange(), this.properties.getQueue(), new GsonBuilder().create().toJson(content));
		
	}
	
	public void sendEmail(Content content) throws IOException, TimeoutException {
		send(content);
	}
}
