# Desafio Git/GitHub
![](https://img.shields.io/badge/tutor-Daniel_Hatanaka-informational?style=flat&logoColor=white&color=cdcdcd)
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
package com.dio
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

