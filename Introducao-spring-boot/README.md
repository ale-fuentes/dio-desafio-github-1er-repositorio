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

**Exercício**

* fazer o build do projeto
* explorar conteúdo do arquivo .jar gerado
* executar o projeto no terminal com java -jar
* trocar o formato do artefato para .war e executar no tamcat
