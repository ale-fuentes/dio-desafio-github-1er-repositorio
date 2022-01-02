# Diretórios e Comandos Essenciais
![](https://img.shields.io/badge/tutor-Bruno_de_Campos_Dias.-informational?style=flat&logoColor=white&color=cdcdcd)

## gerenciamento de pacotes

**pacotes** são programas colocados dentro de um arquivo identificados por sua extensão, e inclue arquivos necessários para a instalação de programas.
existem pacotes com a extensão .deb, .rpm, e outros.

**gerenciadores de pacotes** são sistemas que possuem resolução automática de dependências entre pacotes, método fácil de instalação de pacotes.
exemplos de gerenciadores: dpgk, apt, yum, e outros.

#### gerenciador apt

* install, upgrade, e remove um pacote
```
sudo apt install pacote
sudo apt upgrade pacote
sudo apt remove pacote
```
* update system
```
apt update && apt upgrade
```
para alguns comando, precissamos elevar nosso privilegio, para a tocra de usuario, utilizamos o comando **su**:
```
sudo su
```

sites de pacotes:
[rpm pbone](rpm.pbone.net)

#### gerenciador dpkg
[pkg org](pkgs.org)
para distribuições debian

* install
```
sudo dpkg -i name-package.deb
```
* descrição do pacote
```
sudo dpkg -I name-package.deb
```
* remoção do pacote, se utiliza o nome que se obtem na descrição do pacote.
```
sudo dpkg -r name-description-package
```

## fedora
[fedora](getfedora.org)

#### gerenciador rpm

* install
```
sudo rpm -ivh package.rpm

# with policy dependencies
sudo rpm -ivh --nodeps package.rpm
```
* update
```
sudo rpm -U package.rpm
```
* remove
```
sudo rpm -e package.rpm
```

#### gerenciador yum
gerenciado de pacote rpm.

* install
```
sudo yum install name-package
```
* update
```
sudo yum update name-package
```
* remove
```
sudo yum remove name-package
```
