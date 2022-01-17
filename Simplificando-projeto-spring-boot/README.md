# Simplificando Projetos Java com o Spring Boot
![](https://img.shields.io/badge/tutor-Renan_Marques-informational?style=flat&logoColor=white&color=cdcdcd)

---

## Introdução e apresentação do curso :: Abstraia acomplexidade de configuração com o Spring Boot

Aplicar e entender conceitos do Spring Framework e Spring Boot, ao final ficará mais claro como funciona a injeção de dependência e a inversão de controle do Spring, como geramos o projeto utilizando o Spring Initializr e também entenderemos sobre o Spring Boot Test e a biblioteca Swagger.

## Spring Framework

### Por que Spring?

* O que é o Spring?


Spring nada mais é que uma plataforma com diversos recursos para construção de aplicativos Java, facilitando assim o desenvolvimento em Java EE com módulos que facilitam a construção de softwares reduzindo o tempo de desenvolvimento.

**saber mais**
* [spring io - why spring](https://spring.io/why-spring)
* [snyk.io - ecosystem report](https://snyk.io/blog/jvm-ecosystem-report-2018-platform-application/)

### Beans

Um bean se trata de um objeto que é instanciado, montado e gerenciado por um container do Spring através de Inversão de Controle (IoC) e Injeção de Dependências (DI).

```
CORE CONTAINER______________________________
|                                           |
| [ Beans ] [ Core ] [ Context ] [ SpEL ]   |
|___________________________________________|
```


**Ciclo de vida de um Bean**
É gerenciado pelo spring boot
```
container e iniciado
|\        \
|          -> Bean é Instanciado 
|             |
|             |/
|             Dependências são injetadas
|             |
|             |/
|             Chamada do método de inicialização
|             |
|             |/
|             Bean é utilizado
|             |
|             |/
 \___________ Bean é descartado
```

**Configurando Beans**
É possível configurar um Bean de duas formas por arquivos XML ou através de anotações.

Em XML seria preciso definir a tag `<bean>` dentro de uma tag principal `<beans>` passando o path da classe assim o Spring saberá quais classes gerenciar a criação de instâncias e a injeção de dependências.

Exemplo de um XML

```
<?xml version="1.0" encoding="UTF-8"?> 
<beans xmlns="http://www.springframework.org/schema/beans" 	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 	xsi:schemaLocation="http://www.springframework.org/schema/beans 	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd"> 

<bean id="..." class="...” /> 

</beans> 

```

**BeanFactory ou ApplicationContext?**

* **BeanFactory** fornece um mecanismo de configuração avançada capaz de gerenciar objetos de qualquer natureza. 
* **ApplicationContext** se baseia na BeanFactory (é uma subinterface) e adiciona outras funcionalidades, como integração mais fácil com os recursos AOP do Spring, manipulação de recursos de mensagem (para uso na internacionalização), propagação de eventos e contextos específicos da camada de aplicativo, como o `WebApplicationContext` para uso em aplicativos da web.



### Inversão de Controle (IoC)

Inversão de Controle (ou IoC - Inversion of Control) é um processo onde se inverte o fluxo de comando de um programa. É *uma ideia desacoplar* ou *remover dependências do objeto e fornecer controle para outra camada*. Este objeto delega a tarefa de construir dependências para um contêiner IoC.

```
            passe para
[ CLASS A ] <---------|[ IoC Container ]|--> [ CLASS B ]
                                         cria
```

**exercicio**
Implemente a inversão de controle em um programa simples, seguindo as orientações da aula.

[GitHub : Re04nan - dio spring boot](https://github.com/Re04nan/dio-experts-spring-boot-java)

**exercicio by Alejandro**
Quando la clase A usa alguma funcionalidade de la clase B, então esta clase A tiene que crear una dependencia de la clase B.
Transferir la tarea de crear el objeto en otro local y usando directamente la dependencia es chamada de **injecção de dependencia**


### Injeção de Dependência (DI)

A Injeção de Dependência (ou DI - Dependency Injection) define quais classes serão instanciadas e onde serão injetadas quando for necessário. Existem três formas de aplicar o DI, por injeção de construtor, setter e interface. O Spring Framework aplica a IoC quando necessário também utilizando o DI.

```
              Injetando
[ CLASS A ] <-------------|[ CLASS B ]
              Dependência
```

**exercicio**
Implemente a injeção de dependência em um programa simples, seguindo as orientações da aula.

[GitHub : Re04nan - spring boot java](https://github.com/Re04nan/dio-experts-spring-boot-java)

## Spring Boot

### O que é o spring boot

O Spring Boot é uma extensão do Spring, que utiliza do Spring Framework para iniciar uma aplicação de forma simples e rápida, sem se preocupar com configurações complexas como, por exemplo, o Tomcat.

* Componentes base do Spring Boot:
* Spring Boot Starter;
* Spring Boot Auto-Configuration;
* Spring Boot Actuator;

**Como o Spring Boot Funciona?**

Em resumo o Spring Boot é como um template pré-configurado para desenvolvimento e execução de aplicações baseadas no Spring.
Onde, temos uma arquitetura baseada no Spring Core, que traz os componentes-base do Spring, como o mecanismo de DI/IoC, a Spring Expression Language (SpEL) e alguns módulos-base do Spring AOP (módulo para implementação de programação orientada a aspectos no Spring).

* O Spring Boot permite adicionar a estrutura-base o que é chamado de módulo.
* Um módulo é na verdade uma biblioteca ou ferramenta do ecossistema Spring que pode ser adicionada a uma aplicação Spring convencional.

```
| Spring |   | Spring    |   | Servidor          |   | XML < bean>       |
|  Boot  | = | Framework | + | Embutido          | + | Configuration     |
|        |   |           |   | (Tomcat ou Jetty) |   | ou @Configuration |
```

**Dependências base do Do Spring Boot**

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```


### Motivação do spring boot

Resumidamente o Spring Boot veio para facilitar a vida do desenvolvedor java e melhorar a produtividade do desenvolvimento de softwares. O Spring Boot facilita todo esse processo, fazendo com que o desenvolvedor se concentre mais na parte realmente importante que envolve as regras do negócio e código.

### Spring initializr

O Spring Initializr fornece uma API extensível para gerar projetos baseados em JVM (Java Virtual Machine) é onde podemos criar um projeto Spring Boot de forma rápida e fácil, através do site:

[start spring io](https://start.spring.io/)

**exercicio**

Crie seu primeiro projeto web com Spring Boot com Spring Initializr, seguindo as orientações da aula.

[GitHub : Re04nan - spring boot java](https://github.com/Re04nan/dio-experts-spring-boot-java)


### Auto-configuration

**@SpringBootApplication**

O Auto-configuration ou configuração automática do Spring Boot configura automaticamente a aplicação Spring com base nas dependências jar que adicionamos ao projeto.

Para habilitar o recurso existe a anotação `@EnableAutoConfiguration`, mas essa não é usada porque está contida no `@SpringBootApplication`. A anotação `@SpringBootApplication` é a combinação de três anotações.

```
@SpingBootApplication = @ComponentScan + @EnableAutoConfiguration + @Configuration
```

```
package com.digitalinnovation.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebApplication.class, args);
	}

}
```
```
org.springframework.boot.autoconfigure.SpringBootApplication

@Target(value={TYPE})
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters={@Filter(type=CUSTOM, classes={TypeExcludeFilter.class}), @Filter(type=CUSTOM, classes={AutoConfigurationExcludeFilter.class})})
@Retention(value=RUNTIME)
@Documented
@Inherited
Indicates a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. This is a convenience annotation that is equivalent to declaring @Configuration, @EnableAutoConfiguration and @ComponentScan.

Since:
1.2.0
Author:
Phillip Webb
Stephane Nicoll
Andy Wilkinson
```

## Principais dependências e bibliotecas

### Swagger

Swagger é um projeto open source com diversas ferramentas utilizadas para desenvolver APIs com a especificação OpenAPI Specification (OAS), uma especificação para descrever, produzir, consumir e visualizar serviços de uma API REST. Com o OAS você poderá descrever recursos, URIs, modelo de dados, métodos HTTP aceitos e códigos de resposta.

Tudo isso facilita a vida dos desenvolvedores de diversas linguagens de programação na criação, testes, consumo e documentação de APIs REST.

**dependências**
```
<dependencies>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
</dependencies>
```

> **Note**, Problema com a compilação, resolveu adicionando em `application.properties` o seguinte:
> ```
> spring.mvc.pathmatch.matching-strategy=ant-path-matcher
> ```

**exercicio**
Utilize o Swagger para documentar alguma API REST desenvolvida por você, seguindo as orientações da aula.

[GitHub : Re04nan - spring boot java](https://github.com/Re04nan/dio-experts-spring-boot-java)


### Feign

O Feign é um cliente de serviço web declarativo (cliente HTTP) desenvolvido pela Netflix e um dos mais populares do Spring Cloud Component. Com ele é possível criar clientes API HTTP no java de forma mais simples para chamar/consumir os serviços REST, utilizando anotações.

Para usar o Feign, precisamos adicionar a dependência `spring-cloud-starter-openfeign` no arquivo pom.xml.

**exercicio**
Utilize o Feign para integrar duas APIs ou simular esse tipo de requisição entre dois projetos, seguindo as orientações da aula.

[GitHub : Re04nan - spring boot java](https://github.com/Re04nan/dio-experts-spring-boot-java)

> **Note** problema com lombok, com o metodo `builder()`, se utilizou a seguinte ajuda:
> [projectlombok org](https://projectlombok.org/setup/eclipse)

## Spring boot test

### Visão Geral

O Spring Boot facilita o desenvolvimento de testes de unidade e integração com o Spring Boot Test, um recurso bastante utilizado no desenvolvimento de aplicações java para testar comportamentos do código e regras do negócio.

Para utilizarmos precisamos usar `spring-boot-starter-test` , que importa os módulos de teste Spring Boot, bem como JUnit Jupiter, AssertJ, Hamcrest e várias outras bibliotecas úteis.

**Importância do Teste**

Em desenvolvimento de software, os erros podem aparecer em qualquer etapa do ciclo de vida do projeto. Com isso, o teste de software se torna essencial e não pode ser visto como uma atividade opcional, pois oferece os métodos e ferramentas necessárias para garantir a qualidade de qualquer desenvolvimento.

### Testes Unitários

Os testes unitários é a base da pirâmide de testes onde são realizados o maior número de testes ou deveria para garantir a fidelidade do código e regras do negócio.

```
(+)
| Custos                [Testes Manuais]
| Tempo de execução  [    Testes de UI    ]
| Fidelidade      [    Teste de Integração       ]
|             [         Testes Unitários            ]
(-)          <-----------------------------------> (+)
                           números de testes
```
**exercicio**
Utilize o Spring Boot Test para realizar um pequeno teste unitário em um projeto Spring Boot, seguindo as orientações da aula.

[GitHub : Re04nan - spring boot java](https://github.com/Re04nan/dio-experts-spring-boot-java)

### Explorando o @SpringBootTest

A anotação `@SpringBootTest` é utilizada em uma classe de teste e diz ao Spring Boot para procurar uma classe de configuração principal, por exemplo, o `@SpringBootApplication`, e usá-la para iniciar um contexto de aplicativo Spring.

```
package com.digitalinnovation.springbootweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootwebApplicationTests {

	@Test
	void contextLoads() {
	}

}
```

**exercicio**
Utilize o Spring Boot Test para realizar um pequeno teste de integração em um projeto Spring Boot, seguindo as orientações da aula.

[GitHub : Re04nan - spring boot java](https://github.com/Re04nan/dio-experts-spring-boot-java)

