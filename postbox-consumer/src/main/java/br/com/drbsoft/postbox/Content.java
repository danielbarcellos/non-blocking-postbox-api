package br.com.drbsoft.postbox;

public class Content implements java.io.Serializable{

	/**
	 * 
	 */
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

	public Content(String firstName, String lastName, String userName, String password, String email, String to, String subject,
			 String message, String template) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.subject = subject;
		this.to = to;
		this.template = template;
		this.message = message;
	}

	public Content(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
