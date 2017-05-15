package br.com.drbsoft.postbox.client.api;

import lombok.Data;

@Data
class Content implements java.io.Serializable{

	private static final long serialVersionUID = -8252318041060823678L;
	
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private String subject;

	private String to;

	private String template;

	private String message;
	
	public Content() {
	}
}
