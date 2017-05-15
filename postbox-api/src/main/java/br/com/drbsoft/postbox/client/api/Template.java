package br.com.drbsoft.postbox.client.api;
/**
 * Representa os templates disponiveis de emails.
 * 
 * @author daniel
 *
 */
public enum Template {

	/**
	 * Template de confirmacao de emails
	 */
	EMAIL_CONFIRMACAO,
	/**
	 * Templaate de recuperacao de emails
	 */
	EMAIL_RECUPERAR;

	public static Template get(String templateAsString) {
		if(templateAsString != null && templateAsString != ""){
			if(templateAsString.equals(EMAIL_CONFIRMACAO.name())){
				return Template.EMAIL_CONFIRMACAO;
			}else if(templateAsString.equals(EMAIL_RECUPERAR.name())){
				return Template.EMAIL_CONFIRMACAO;
			}
			
		}
		return null;
	}
}
