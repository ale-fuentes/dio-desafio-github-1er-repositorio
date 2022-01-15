# Introdução Spring Boot
![](https://img.shields.io/badge/tutor-Rodrigo_Peleias.-informational?style=flat&logoColor=white&color=cdcdcd)
---

> requisitos básicos
> * java 8 ou versão superiores
> * maven 3.5.2 ou versão superior
> * intellij idea community edition ou sua ide favorita

## O que é o spring boot?

#### O que é e quais problemas resolvem o spring boot?

**Problemas do spring**
* configurações de beans em arquivos.xml
* dispatcher servlet e view resolver em web.xml
* setup manual de banco de dados
* muito tempo gasto em configuração
* perda de foco em valor

**O que é o spring boot?**
* criado pela spring source em 2012
* facilita setup de projetos spring
* sem necessidade de criar arquivos de configuração
* foco em produtividade
* mairo tempo no desenvolvimento de valor

[spring projects](https://i0.wp.com/www.zoltanraffai.com/blog/wp-content/uploads/2018/07/what-is-spring-boot.png?w=1033&ssl=1)

**Quais problemas resolve?**
* **produtividade**, setup simplificado de projeto
* **starters**, dependências auto configuráveis pelo spring boot
* **execução simplificada**, sem deploy em servidor externo
* **configuração**, arquivo externo para configuração
* **valor**, maior tempo em desenvolvimento


**Exercício**

* criação de um projeto no site [spring io](http://start.spring.io)
* importar o projeto na sua IDE
* adicionar **spring-boot-starter-mvs** no pom.xml
* adicionar classe *HelloController* e o método *hello()*
* executar o projeto através do terminal


#### Auto configuration
**antes do spring boot**

> Sprint will load...
> dispatcher + "-servlet" = **dispatcher-servlet.xml**

```
<servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org...DispatcherServlet</servlet-class>
    <servlet-startup>l</servlet-startup>
</servlet>
```

* múltiplos arquivos xml
* configuração manual do spring mvc: dispatcher servlet, web.xml, spring-mvc.xml
* configuração manual dos beans spring
* aplicado também ao spring data, spring security, etc
* **starters**, dependências simplificadas e auto configuráveis
```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```
* identificação e configuração automática da dependência
* spring boot detecta as dependências e configura para nós
```
| +--- META-INF
| |     \--- spring.factories
| +--- org.springframework.boot.autoconfigure
(...)
| |     +--- jdbc
| |     |     \--- DataSourceAutoConfigure
(...)
| |     +--- web
| |     |     +--- DispatcherServlerAutoConfiguration
| |     |     +--- EmbeddedServletContainerAutoConfiguration
| |     |     \--- WebMvcAutoConfiguration
(...)
| |     +--- orm.jpa
| |     |     +--- HibernateJpaAutoConfiguration
| |     |     \--- JpaBaseConfiguration
| |     \--- EnableAutoConfiguration
```
* projeto simplificado e pronto para foco no valor



**Exercício**

* adicionar propriedade `debug=true` no **applicatoin.properties**
* executar projeto no terminal e analisar o log
* identificar e visualziar o auto configuratoin do spring mvc
* visualizar a dependência do auto configuration do projeto

#### FatJar/UberJar
**antes do spring boot**
* spring tradicional: war precisa de servidor de aplicação
* dependência de um container web ou servidro de aplicação
* complexisdade de configurações
* atualizações frequentes, junto com versão do projeto
* gerenciamento manual de configurações

**fatjar/uberjar**
* artefato do projeto pronto para execução
* container web embutido na geranção e execução (tomcat)
* deploy embarcado com outro containers são opcionais
* dependências principais do projeto embarcado

```
Fat/Uber
▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
▓ Thin                        ▓
▓ ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▓▒░
▓ ▒   Skinny               ▒  ▓▒░
▓ ▒   ░░░░░░░░░░░░░░░░░░░░ ▒  ▓▒░
▓ ▒   ░ app              ▒ ▒  ▓▒░
▓ ▒   ░░░░░░░░░░░░░░░░░░░░ ▒  ▓▒░
▓ ▒                        ▒  ▓▒░
▓ ▒   app Dependencies     ▒  ▓▒░
▓ ▒                        ▒  ▓▒░
▓ ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▓▒░
▓                             ▓▒░
▓ Hollow                      ▓▒░
▓ ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▓▒░
▓ ▒                        ▒  ▓▒░
▓ ▒   app Runtime          ▒  ▓▒░
▓ ▒                        ▒  ▓▒░
▓ ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▓▒░
▓                             ▓▒░
▓                             ▓▒░
▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒░
 ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░
  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
```
* execução direta através de um único java -jar
```
mvn package && java -jar target/spring-boot-example-0.1.0.jar
```
* podemos também gerar o war tradicionalmente
alterando nosso arquivo `pom.xml`
```
<packaging>war<packaging>
```
**Exercício**

* fazer o build do projeto
* explorar conteúdo do arquivo .jar gerado
* executar o projeto no terminal com java -jar
* trocar o formato do artefato para .war e executar no tomcat
```
mvn clean package
```
apos de build success
```
cd /target
ll
```
na lista de arquivo estar nosso projeto .jar
executar o jar
```
java -jar <nome-projeto>.jar
```
para verificar o conteudo do jar
```
jar tf springboot.jar | less
```
mudar no arquivo pom.xml para que o package gere um pacote war.
```
<packaging>war<packaging>
```
depois, grar novamente o package
```
mvn clean package
cd /target
ll
```
na lista de arquivo esta nosso projeto .war
move projeto war dentro do tomcat, na pasta `webapps`
```
mv target/<nome-projeto>.war apache-tomcat-9.0.26/webapps
```
verificamos a copia
```
ll apache-tomcat-9.0.26/webapps
```
estara nosso projeto .war
subir o tomcat
```
cd apache-tomcat-9.0.26/
cd bin/
./startup.sh
```


#### Exemplos
[GIT - springboot digital innovation one](http://github.com/rpeleias/springboot_digital_innovation_one)

#### Referências
* [dzone - spring boot tutorial](https://dzone.com/articles/spring-boot-framework-tutorials)
* [tutorialspoint - o que é spring boot](https://www.tutorialspoint.com/spring_boot/spring_boot_introduction.htm)
* [spring io - features](https://docs.spring.io/spring-boot/docs/2.2.0.M5/reference/html/spring-boot-features.html)


---

## Trabalhando com profiles e configurações

#### Importância dos profiles

* ambiente para desenvolviemnto, teste e produção
```
Local
Development |---> Development |---> Staging |---> Production
```
* como seria configurar o bancos de dados para cada ambiente
* execução de testes unitários em ambiente local
* suíte de testes completas em ambiente de teste
* simulação do ambiente real em staging
* deploy simplificado em produção

para esa lista de assunto, tem os profiles que bem para ajudar em:

* Configurações próprias para cada ambiente
* ambiente com sua configuração: dev, production
```
src
|--main
   |--java
   |--resource
      |--application.properties
      |--application-dev.properties
      |--application-release.properties
```

#### Configurações com arquivos properties

mapeamento de properties:
```
@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DBConfiguration {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    ...
    ...
}
```

exemplo de profiles DEV:
```
@Profile("dev")
@Bean
public String devDataBaseConnection() {
    System.out.println("DB connection for DEV - H2");
    System.out.println(driverClassName);
    System.out.println(url);
    return "DB connection for DEV - H2";
}
```
PRO:
```
@Profile("prod")
@Bean
public String prodDataBaseConnection() {
    System.out.println("DB connection to RDS_PROD - High Performance Instance");
    System.out.println(driverClassName);
    System.out.println(url);
    return "DB connection to RDS_PROD - High Performance Instance";
}
```

**Exercício**

* projeto com spring.initialzr e importar no IDE
* arquivos application.properties para dev e prod
* classe de configuração de BD e anotar com @Configuration
* mapear propriedades com @ConfigurationProperties
* criar métodos para instanciar beans de cda env
* criar classe anotada com @RestController
* injetar propriedade appMessage com @Value
* criar método que retorna a messagem acima
* executar projeto no browser

criar o projeto no `https://start.spring.io/`, é para os metodos getters e setters, se usara uma biblioteca chamada `lombok`.

```
	<dependency>
		<groupId>org.projectlombok</groupId>
		<artifactId>lombok</artifactId>
		<version>1.18.22</version>
		<scope>provided</scope>
	</dependency>
```
em `applicatoin.properties` vamos a criar uma propriedade básica:
```
#definir qual profile sera ativa
spring.profiles.active=dev

spring.application.name=Spring Boot Configuration Project
```

executamos noss projeto
```
mvn spring-boot:run
```

#### Configurações com arquivos YAML
* troca no formato de configurações: formato .YAML
* pode estar junto com o .properties
* diferenças:

.properties
```
basic.value: true
basic.message: Dynamic Message
basic.number: 100
```
.YAML
```
basic:
    value: true
    message: Dynamic Message
    number: 100
```

**Exercício**

* Migrar app.properties do profile dev para YML
* executar o projeto pelo terminal

#### Configurações com command line

* propriedades do arquivo de configuração na linha de comando
* sobrescreve as propriedades definidas no arquivo de configurações padrão
* valores passados como argumento na execução do projeto tem prioridade maior

.properties
```
server.port=8081
spring.application.name=SampleApp
```
linha de comando
```
mvn spring-boot:run -Dserver.port=8085
```

**Exercício**

* passar como argumento a propriedade server.port=8085
* executar o projeto no terminal com o argumento
* abrir o browser no endereço `http://localhost:8085`


#### Configurações com variáveis de ambiente

* variável de ambiente pode ser injetada através da anotação `@Value` no projeto
* linux e mac: export comum de variável:
```
export ENV_DB_URL=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1
```
* windows: padrão de variável de ambiente
* injeção com anotação `@Value(${NOME_VARIAVEL})`
* definição de valor default quando não há variável
```
@Value("${ENV_DB_URL:NENHUMA}")
private String dbEnvironmentVariable;
```

**Exercício**

* injetar a variável com `@Value` em `AppController`
* definição de valor default junto com a anotação `@Value`
* criar método para chamada do novo método e exibir o valor
* executar projeto no terminal e exibir no browser

#### Exemplos
[GIT - springboot profile digital innovation one](http://github.com/rpeleias/springbootprofile_digital_innovation_one)

#### Referências
* [baeldung - spring boot command line arguments](https://www.baeldung.com/spring-boot-command-line-arguments)
* [dzone - spring boot profiles 1](https://dzone.com/articles/spring-boot-profiles-1)
* [spring io - boot features profiles](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-profiles.html)
* [spring io - boot features profiles external](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config)
