package br.com.drbsoft.postbox;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class PostboxMailProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message message = exchange.getIn();
		Object body = message.getBody();
		
		Gson gson = new GsonBuilder().create();
		Content content = gson.fromJson((String) body, Content.class);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		
		// TODO Criar forma de dinamicamente settar estes headers abaixo
		headers.put("firstName", content.getFirstName());
		headers.put("lastName", content.getLastName());
		headers.put("userName", content.getUserName());
		headers.put("email", content.getEmail());
		headers.put("password", content.getPassword());
		headers.put("to", content.getTo());
		headers.put("subject", content.getSubject());
		
		headers.put("CamelVelocityResourceUri", "classpath://template/" + content.getTemplate() + ".html");
		
		
		
		message.setHeaders(headers);
	}

}
