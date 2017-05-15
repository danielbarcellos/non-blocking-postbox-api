package br.com.drbsoft.postbox.client;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import br.com.drbsoft.postbox.client.api.PostboxProperties;
import br.com.drbsoft.postbox.client.api.Postman;
import br.com.drbsoft.postbox.client.api.Template;

public class PostboxApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void test_sendEmail() throws IOException, TimeoutException{
		
		new Postman(new PostboxProperties("localhost", 5672))
		
			.template(Template.EMAIL_CONFIRMACAO)
			
				.firstName("Daniel")
				.lastName("Barcellos")
				.username("daniel")
				.password("123")
				.email("danielbarcellos@drbsoft.com.br")
				
			.to("danielbarcellos@drbsoft.com.br")
			.subject("Job promotion")
			.message("Congratulations you have been promoted!")
			
			.send();
	}
}
