package br.com.drbsoft.postbox.client.api;

public class PostboxProperties {

	private static final String QUEUE_NAME = "nwrs.postbox.queue";
	private final static String EXCHANGE_NAME = "nwrs.postbox";
	
	private String host;
	private int port;
	private final String queue = QUEUE_NAME;
	private String exchange = EXCHANGE_NAME;

	public PostboxProperties(String host, int port) {
		this.setHost(host);
		this.setPort(port);
	}
	
	public PostboxProperties(String host) {
		this.setHost(host);
	}
	
	
	public PostboxProperties() {
		this.host = "localhost";
		this.port = com.rabbitmq.client.ConnectionFactory.DEFAULT_AMQP_PORT;
	}

	public int getPort() {
		return port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getExchange() {
		return exchange;
	}
	
	public String getQueue() {
		return queue;
	}

}
