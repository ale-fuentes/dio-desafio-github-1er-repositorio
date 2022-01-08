# Desafio Git/GitHub
![](https://img.shields.io/badge/tutor-Daniel_Hatanaka-informational?style=flat&logoColor=white&color=cdcdcd)
![](https://img.shields.io/badge/SO-Linux-informational?style=flat&logo=Linux&logoColor=white&color=cdcdcd)
![](https://img.shields.io/badge/Java-Language-informational?style=flat&logo=Java&logoColor=white&color=007acc) ![](https://img.shields.io/badge/Eclipse-IDE-informational?style=flat&logo=Eclipse&logoColor=white&color=fa962a) ![](https://img.shields.io/badge/Intellij_IDEA-IDE-informational?style=flat&logo=IntellijIDEA&logoColor=white&color=fa962a) 

---
## ecossisema e documentação java

características de java:
* compilada
* interpretada
* fortemente tipada
* liguagem de alto nível
* executada em uma máquina virtual, jvm (java virtual machine)

jvm é uma máquina virtual responsável pela tradução dos bytecodes oriundos do compilador javac (java compiler) em código de máquina de cada sistema operacional
* execução de pilhas
* gerenciamento de memória
* gerenciamento de threads
* otimização de código (compilação jit - just in time)
* garbage collector (gc)

quais diferenças entre jre e jdk?
* jre, java runtime environment, responsável por executar os programas em java
* jdk, java development kit, utilitários que permite o desenvolvimento de programas em java. jápossui a jvm para executar os programas

quais são os tipos de plataformas java?
* java se, java standard edition, contém as espefiiccaç]oes do java e pode ser implementado por diversas empresas como oracle, openjdk, azul zulu, etc
* java ee, java enterprise edition, contém todas as espeficicações do java se e um número de programas úties para que executam em servidores. em 2019 foi renomeado para jakarta ee.
* java me, java micro edition, contém especificações para desenvolvimento de programas para dispositivos pequenos como celulares, pdas, etc.

quais as implementações java se?
* openjdk
* oracle jdk
* adoptopenjdk
* amazon corretto
* graalvm ce
* azul zulu

#### instalando a jvm

utilizando o curl
```
sudo apt install curl
```

**instalando java version manager**

* [java version manager](https://github.com/shyiko/jabba)
* utilizando curl:
```
curl -sL https://github.com/shyiko/jabba/raw/master/install.sh | bash && . ~/.jabba/jabba.sh
```
**utilizando java version manager**

```
jabba ls-remote
jabba install openjdk@1.11
jabba use openjdk@1.11
java -version
```

#### executando um programa java

criando classe principal na pasta `src/com/dio/MyFirstProgram.java`:

```
package com.dio;
import com.dio.base.Order;

public class MyFirstProgram {
    public static void main(String[] args){
        final Order order = new Order("code1234");
        System.out.println(order);
    }
}
```
criando uma classe secundaria na pasta `src/com/dio/base/Order.java`:
```
package com.dio.base;

public class Order{
    private final String code;

    public Order(String code){
        this.code = code;
    }

    @Override
    public String toString(){
        return "Order={" +
            "code = '" + code + "'" +
            "}";
    }
}
```
**compilando**

```
jabba use openjdk@1.11
javac -d target/ -sourcepath src/ src/com/dio/MyFirstProgram.java
```

**executando**

```
cd target/
java com.dio.MyFirstProgram
```

## Constextualização de uso de java Versão 11


#### Palavras reservadas

java tem uma lista de palavras reservadas or [keywords](https://en.wikipedia.org/wiki/List_of_Java_keywords):

| | | | | | |
| :--- | :--- | :--- | :--- | :--- |:--- |
|<td colspan=5>keywords java|
| abstract | continue | float | native |strictfp | void
|assert|default|for|new|super|volatile
|boolean|do|goto|null|switch|while
|break|double|if|package|synchronized
|byte|else|implements|private|this
|case|enum|import|protected|throw
|catch|extends|instanceof|public|throws
|char|false|int|return|transient
|class|final|interface|short|true
|const|finally|long|static|try


#### Declaração de classes

* estrutura básica de uma classe:
```
public class Order {

}
```
* estrutura com atributos e métodos:
```
public class Order {
    private final String code;
    private final BigDecimal totalValue;

    public BigDecimal calculateFee(){
    }
}
```
* estrutura completa de uma classe:
```
package com.dia.base;

import java.math.BigDecimal;

public class Order {
    private final String code;
    private final BigDecimal totalValue;

    public Order(String code, BigDecimal totalValue) {
        this.code = code;
        this.totalValue = totalValue;
    }

    public BigDecimal calculateFee() {
        return this.totalValue.multiply(new BigDecimal("0.99"));
    }
}
```

#### Modificadores de acesso

segun o tipo, poderá acessar o atributo ou método:

* **public**, qualquer classe de qualquer pacote
* **protected**, qualquer classe definida no mesmo pacote ou subclase
* **sem modificador**, apenas classes definidas no mesmo pacote
* **private**, apenas a própia classe

#### Métodos

são funções que definem o comportamento de uma classe.
* **métodos construtores**, definem como uma classe será instanciada "construida"
* **métodos comum**, definem comportamentos que podem ou não estar atribuídas às regras de negócio. ex: calcular taxas de um pedido, etc

#### Estrutura de condição

é responsável por fazer o desvio do fluxo de execuão do código de acordo com uma dada condição
* if - else
```
    public double calculateFee(){
        if(this.totalValue > 100 ){
            return this.totalValue * 0.99;
        }else {
            return this.totalValue;
        }
    }
```
* switch - case
```
    public double calculateFeeV2(){
        switch (this.totalValue){
            case 100:
                return this.totalValue * 0.99;
            case 200:
                return  this.totalValue * 1.99;
            default:
                return this.totalValue;
        }
    }
```


#### Estrutura de repetição
é responsável por executar repetitivamente uma instrução ou um bloco de instruções até uma condição estiver sendo satisfeita
* while
```
    public void printItemsWithWhile(){
        int i=0;
        while(i < this.items.length){
            System.out.println(this.items[i]);
            i++;
        }
    }
```
* do - while
```
    public void printItemsWithDoWhile(){
        int i=0;
        do {
            System.out.println(this.items[i]);
            i++;
        }while(i < this.items.length);
    }
```
* for
```
    public void printItemsWithFor(){
        for(int i = 0; i < this.items.length; i++){
            System.out.println(this.items[i]);
        }
    }
```
* enhanced for
```
    public void printItemsWithEnhancedFor(){
        for(String i : this.items){
            System.out.println(i);
        }
    }
```

## Documentação java


#### Comentários em linha
se faz utilizando a sua barras `//`
#### Comentários em bloco
se faz utilizando para digitar um comentário mais extenso.
se iniciar com `/*` e finaliza com `*/`.

#### javadoc
é uma ferramenta para documentação no formato HTML que se baseia nos comentários do código-fonte.
os comentários precisam conter tags para que a documentação dique legível.

**Tags javadoc** 
* **@author**, especifica o autor da classe ou do método
* **@deprecated**, identifica classe ou métodos obsoletos
* **@link**, possibilita a definição de um link para um outro documento local ou remoto através de um URL
* **@param**, descreve um parâmetro que será passado a um método
* **@return**, descreve qual o ti´po de retorno de um método

```
javadoc -d javadoc/ -sourcepath src/ -subpackages com.dio
```

## Mercado e carreira java

#### Comunidade java
* o tamanho da comunidade auxilia na escolha de uma linguagem de programação de uma empresa
* qualidade e facilidade para encontrar informações sobre a linguagem diminuem a curva de aprendizado
* atualmente existem comunidades de tecnoogias onde é possível encontrar um grup voltado para a linguagem

**comunidades**
* [OpenSanca](opensanca.com.br)
* [SouJava](soujava.org.br)
* [DevOpsPBS](devopspbs.org)

#### Carreira
* muitas empresas de tecnologia aplicam a carreira em "Y"
* é importante se especializar em uma área: backend, frontend, SRW (site reliability engineering), data engineer, etc
* esclher e focar em uma plataforma de desenvolvimento java: web, desktop ou mobile

**carreira em "Y"**

.................(tecnico)...................(gestion)
.................Especialista..............IV Diretor
.................Especialista..............III Gerente Geral
.................Especialista..............II Gerente
.................Especialista..............I Coordenador
................../....................Senior
intermedio |....................Pleno
...................\\...................Junior
(inicial).........................Estagiario

#### Mercado atual
* atualmente o mercado para profissionais de TI em geral está em alta
* o mercado está carente de profissionais qualificados
* startups de diversos ramos adotaram a linguagem java: PagSeguro, iFood, AWS, MercadoLivre, Itaú, C6 Bank, Dafiti, Luizalabs, etc.

#### Requisitos do profissional
* ao evoluir na carreira de java ou em qualquer carreira de TI é necessário desenvolver tanto soft skills quanto hard skills
* cada vez mais soft skills estão se tornando mais prioritárias que hard skills

**soft skills**
* resolução de problemas complexos
* pensamento crítico
* criatividade
* gestão de pessoas
* coordenação em equipe
* liderança

**hard skill**
* sprit boot
* spring cloud
* apache kafka
* RabbitMQ
* arquitetura cloud
* banco de dados relacional e não relacional
