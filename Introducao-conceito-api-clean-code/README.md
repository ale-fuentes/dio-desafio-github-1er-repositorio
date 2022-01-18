# Desafio Introdução aos conceitos de api e clean arquitecture
![](https://img.shields.io/badge/tutor-Jether_Rodrigues-informational?style=flat&logoColor=white&color=cdcdcd)
* [slider do curso](https://drive.google.com/file/d/1NJD-33oiHjCfax1VPIBzVuw73iFuzPiV/view)
---
## Conceito inicial sobre REST

* é um acrônimo de representanção de transferência de estado (REpresentational State Transfer)
* é um estilo arquitetural apresntado por Roy Fielding (HTTP e REST)
* interoperável e agnóstico a linguagem ou tecnologia (meio de integraçãp entre sistemas de qualquer stack tecnológica)

#### Constraints

* **Interfac uniforme** baseado em recursos, interfaces por onde o cliente se comunica com o servidor
* **Cliente-Servidor**, cliente é servidor, podem existirem e serem desenvolvimdos separadamente, são independentes
* **Sem estado**, o servidor não guarda estado, sessão, necessário sempre, a cada requisição, caso necessário, informar o servidor de quem está requerendo o dado específico
* **Cache**, funcionalidade que elimina, dado algumas configurações, votlanr ao servidor, se a requisição se repetir dentro de um tempo. Cache pode ser gerenciado em modo client ou server side
* **Sistema em camadas** pode ser sem estado, permite distribuir as implantações e ou recursos, ex.: API em um servidor, data storage em outro e sistmea de autenticação em um terceiro servidor
* **Código sobre demanda (opcional)** possibilidade de retornar "executáveis" via API para rederização de algum componente se necessário

#### Resource Naming Guide

* Estratégia para expor recursos (plural ou singular)
* Estrutura de nome apra recuperar recursos, armazenar, detalhe, nomes compostos, passar parametros (query param, path param)
* URI (endereçamento para um determinado recurso)

```
http//www.michaelcropper.co.uk/seo-tools/uri-encoder-decoder-tool-for-seo?name=value&another-name=value
```
>*  **domain**: the physical server where your website is hosted: *http//www.michaelcropper.co.uk/*
>*  **URI**: the identifier which aps to files on your server: *seo-tools/uri-encoder-decoder-tool-for-seo*
>*  **Query String**: part of a GET request to easily pass in values to customise the output: *?name=value&another-name=value*
>
> **Note** URI stands for Uniform Resource Idendtifier

#### Caching

* Capacidade de manter cópias de um response armazenadas por um tempo determinado
* Elementos
    * tempo de expiraçõa
    * cache-control
    * e-tag
    * last modified
* Cuidados

#### Versionamento

Permite evolução de uma API sem trazer quebra de contratos para os clientes (mudanças em request e responses, remoção de API)
Tipo:
* URI: `http://api.example.com/v1`, `http://apiv1.example.com`
* Header Customizado: `Accept-version: v1`
* Content Negotiation (`Accept Header`): 
    * Accept: application/vnd.example.v1+json
    * Accept: application/vnd.example+json;version=1.0

#### Verbos HTTP

* GET
* POST
* PUT
* PATCH
* DELETE

#### Códigos HTTP

* 1xx - informações
* 2xx - sucesso na requisição
* 3xx - redirecionamentos
* 4xx - erro no lado do cliente
* 5xx - erro no lado do servidor

[http status](https://httpstatuses.com)

#### Idempotência

Uma requisição idepotente é aquela que , independente da quatidade de vezes que se execute, o efeito é o mesmo que da primeira execução.

* POST, altera estado no servidor, cria recurso, logo, não é idempotente
* GET, PUT, DELETE, HEAD, OPTIONS e TRACE são idempotentes

#### N+1 em REST APIs

Problema da necessidade de chamar mais de uma requisição para completar um componente.

## Conceito sobre arquitetura hexagonal

#### Conceito iniciais sobre API FIRST

* [swagger io - Understanding  the API-First Approach to Building Products](https://swagger.io/resources/articles/adopting-an-api-first-approach)
* [editor swagger](https://editor.swagger.io)

#### Agenda API

* Pré-requisito
* Arquitetura hexagonal aplicado ao projeto
    * Application Layer
        * Configs
        * Controllers (conceito de fronteira)
            * DTOs (request, response)
            * Bean Validations
            * Init Binders (validações customizadas)
            * Error Handlers
* Domain Layer
    * Entidades
    * Portas (interfaces)
    * Services
* Resource Layer
    * Spring data repository
    * Proxy repository (composição com spring data repository e implementação interface repository do domínio)
    * Entidades mapeadas com anotações de acordo com tecnologia de banco de dados escolhida para o projeto
* Testes
* [start spring io](https://start.spring.io)
* Dockerização
    * Script e configuração para criação de imagem
    * Compose yaml do serviço
    * Usando o docker-compose para subir o serviço
* Heroku
    * Criando uma app
    * Conectando com o github do projeto
    * Automatizando o pipeline de deploy

#### Agenda Clean Architecture

Principal objetivo de uso de Clean Architecture é fornecer aos desenvolvedores uma maneira de organizar o código de forma que encapsule a lógica de negócios, mas mantenha-o separado do mecanismo de entrega.

Vantagens:
* Independência de interfaces de usuário
* Independência da stack tecnológica utilizada para acesso aos dados e ou expor entradas
* Testável
* Carga cognitiva de entendimento do projeto, regras de negócio
* Facilita manutenabilidade

---
[sdkman](https://sdkman.io)