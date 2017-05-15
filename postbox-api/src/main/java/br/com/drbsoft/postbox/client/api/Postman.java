package br.com.drbsoft.postbox.client.api;

import static br.com.drbsoft.postbox.client.api.utils.Utils.checkNotNull;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Postman {

	private Content content = new Content();
	
	private PostboxProperties properties;

		public Postman(PostboxProperties properties) {
		this.properties = properties;
	}

	public Postman template(Template template) {
		checkNotNull(template, "Template must nos be null");
		this.content.setTemplate(template.name());
		return this;
	}

	public Postman firstName(String firstName) {
		this.content.setFirstName(firstName);
		return this;
	}

	public Postman lastName(String lastName) {
		this.content.setLastName(lastName);
		return this;
	}

	public Postman password(String password) {
		this.content.setPassword(password);
		return this;
	}

	public Postman email(String email) {
		this.content.setEmail(email);
		return this;
	}

	public Postman to(String to) {
		this.content.setTo(to);
		return this;
	}

	public Postman subject(String subject) {
		this.content.setSubject(subject);
		return this;
	}

	public Postman message(String message) {
		this.content.setMessage(message);
		return this;
	}

	public void send() throws IOException, TimeoutException {
		PostmanExecutor executor = null;
		if (properties != null) {
			executor = new PostmanExecutor(properties);
		}

		executor.sendEmail(this.content);
	}

	public Postman username(String username) {
		this.content.setUserName(username);
		return this;
	}

}
