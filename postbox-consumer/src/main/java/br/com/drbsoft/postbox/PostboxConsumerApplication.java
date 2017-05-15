package br.com.drbsoft.postbox;



import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
public class PostboxConsumerApplication {
	
	@Autowired
	Processor processor;

	@Bean
	RouteBuilder postBoxRouteBuilder() {
		return new RouteBuilder() {


			@Override
			public void configure() throws Exception {
				from("rabbitmq://{{rabbitmq.host}}:{{rabbitmq.port}}/{{rabbitmq.exchange}}?exchangeType={{rabbitmq.exchange.type}}&autoDelete={{rabbitmq.exchange.autoDelete}}&queue={{rabbitmq.exchange.queue}}")
				.convertBodyTo(String.class)
				.process(processor)
				.log("${headers} and ${body}.")
				.to("velocity:template/letter.vm?encoding=utf-8")
				.to("smtp://{{mail.smtpServer}}?from={{mail.username}}&to=${in.header.to}&contentType=text/html&subject=${in.header.subject}");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(PostboxConsumerApplication.class, args);
	}
}
