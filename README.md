#  Postbox

O projeto `non-blocking-postbox-api` tem por objetivo disponibilizar uma arquitetura de mensageria utilizando [RabbitMQ](https://www.rabbitmq.com/) Exchanges and Queues visando tornar operações de envio de e-mails "as non blocking api".

Este projeto é basicamente um projeto modularizado utilizando [Gradle](https://gradle.org/). Há nele dois módulos: `postbox-consumer` e `postbox-api`. O primeiro módulo é o consumidor da fila de emails contendo nele um [Apache Camel](http://camel.apache.org/) que tem por objetivo endereçar, conforme parametros informados, os e-mails utilizando-se para isso de templates gerenciados pelo [Apache Velocity](http://velocity.apache.org/).

## Iniciando

Baixe ou clone o projeto.

### Prerequisitos

Java 8+, Gradle 3+, RabbitMQ Server (para teste locais)

### Installing

Clonando o projeto

```
git clone ...
cd non-blocking-postbox-api
```

Instalando o RabbitMQ Server. Veja o [installation guide](https://www.rabbitmq.com/download.html) para maiores informações de como instalar de acordo com a plataforma utilizada. Instale também o plugin management para ter acesso a interface web de administração.

## Running the tests

Para testar utilizando settup local siga os passos abaixo.

### "Startando" o consumer.

Aqui você irá iniciar o consumer da fila/exchange localhost do RabbitMQ Server.

```
cd non-blocking-postbox-api

gradle :postbox-consumer:clean
gradle :postbox-consumer:build -x test

java -jar -Drabbitmq.host=localhost build/libs/postbox-consumer-X.X.X.jar
```

### Parametros utilizados pela api.

Até o presente momento apenas valores sem espaços são válidos.

Os parâmetros válidos são:

* **firstName** - Primeiro nome
* **lastName** - Sobrenome
* **userName** - login, usuário, username.
* **email** - Email do usuário.
* **password** - Senha
* **to** - Email de destino. Utilze vírgulas para separar mais de um destinatário.

```
.to(email1@domain.com,email2@domain.com,email3@domain.com)
```

* **subject** - Assunto do e-mail
* **template** - Modelo de mensagens. Veja Templates.
* **message** - Mensagem.

>**Nota:** não utilizar espaços em valores dos parâmetros.

### Templates

Até o momento há dois templates válidos: `EMAIL_CONFIRMACAO` e `EMAIL_RECUPERAR`


>**Nota:** os templates names são todos case sensitives.

### Enviando e-mails utilizando a api.

A api fornece uma interface fluente para o envio de emails conforme abaixo.

```java
package br.com.drbsoft.postbox.client;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import br.com.drbsoft.postbox.client.api.PostboxProperties;
import br.com.drbsoft.postbox.client.api.PostmanBuilder;
import br.com.drbsoft.postbox.client.api.Template;

public class PostmanTest {

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
```

## Versionamento

We use [Gitlabs](https://github.com) for versioning. For the versions available, see the [tags on this repository](https://github.com/danielbarcellos/non-blocking-postbox-api). 

## Autores

* **Daniel Barcellos** - *Initial work* - [Daniel Barcellos](https://github.com/danielbarcellos)

## License

GNU General Public License v3.0.

## Agradecimentos

* My family...

