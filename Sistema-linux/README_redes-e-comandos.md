# Diretórios e Comandos Essenciais
![](https://img.shields.io/badge/tutor-Bruno_de_Campos_Dias.-informational?style=flat&logoColor=white&color=cdcdcd)

## fundamentos de redes e comandos avançãdos
**rede*** de computadores é um conjunto de equipamentos interligados de maneira a trocarem informações e compartilharem recursos, como arquivos de dados gravados, impressoras, modems, softwares e outros equipamentos. -: sousa, 1999

* **wan** wide area network ou world area network é uma rede geograficamente distribuída
* **man** metropolitan area network é uma rede metropolitana que iterligam várias redes locais
* **lan** local area network é uma rede local de uma forma geral em um único prédio ou campus
* **protocolos** é a linguagem usada pelos dispositivos de uma rede de modo que eles consigam se entender -: torres, 2004

**existem vários protocolos**
* **ip** protocolo de internet, endereço ip, número que identificam seu computador em uma rede
* **icpm** internet control message protocol, tem por objetivo prover mensagens de controle na comunicação entre nós
* **dns** domain name server, esse protocolo de aplicação tem por função identificar endereços IPs manter uma tabela com os endereços dos caminhos de algumas redes

**interface de rede**
* **interface de rede** é um software e/ou hardware qeu faz a comunicação em uma rede de computadores. as interfaces de rede no linux estão localizadas no diretório /dev e a maioria é criada dinamicamente pelos software quando são requisitadas
exemplo: eth0 - placa de rede ehternet - cabeada
* **interface loopback** é um tipo esécial de interface que permite fazer conexões com você mesmo, com ela, você pode testar vários programas de rede sem interferir em sua rede. padrão, o endereço ip 127.0.0.1 foi escolhido para loopback

### comandos

> **NOTE**
> if need install it, usse next command: 
> * sudo apt install net-tools
> 
> if need install tranceroute: 
> * sudo apt install inetutils-traceroute
> * sudo apt install traceroute
> 
> if need install whois:
> * sudo apt install whois
> 
> if need install finger:
> * sudo apt install finger
> 
> if need install cowsay:
> * sudo apt install cowsay
> 
> if need install xcowsay:
> * sudo apt install xcowsay
> 
> if need install cmatrix:
> * sudo apt install cmatrix




* **ipconfig** listing all net interface
* **hostname** infomation about our host
* **hostname -I** address ip
* **hostname -i** address loopback ip
* **w** get details informatin about user to computer in the net
* **who** how to logged its net
* **whoami** name usser logged its net
* **ping ip/addressnet** analisy connection
* **ping address -w 4** much package send this test
* **dig address** information about dns to address
* **dig address +short** only ip to address
* **traceroute address**  information to path from our host to get address
* **whois address** get various information to address (domain, country, etc)
* **finger** get all information to all users login in our net

### Exercícios Práticos

1) Crie um arquivo de aularedes.txt
2) Exiba o número de IP da rede no terminal
3) Adicione a saída do comando anterior ao arquivo aula redes.txt
4) Exiba o número de IP Loopback no terminal
5) Adicione a saída do comando anterior ao arquivo aula redes.txt
6) Exiba Informações DNS sobre o host www.pudim.com.br
7) Adicione a saída do comando anterior ao arquivo aula redes.txt
8) Exiba Informações do Usuário logado na rede
9) Adicione a saída do comando anterior ao arquivo aula redes.txt
10) Execute um teste no host www.pudim.com.br com 6 pacotes
11) Adicione a saída do comando anterior ao arquivo aula redes.txt
12) Trace a Rota do seu computador até o host www.pudim.com.br
13) Adicione a saída do comando anterior ao arquivo aula redes.txt
14) Exiba Informações sobre Interfaces de Rede e Endereços IP no terminal
15) Adicione a saída do comando anterior ao arquivo aula redes.txt
16) Limpe o terminal
17) Imprima o arquivo aularedes.txt com paginação no terminal


## fuçando no linux com comandos diversos
some comands:

* **history -c** clear history
* **alias nick=command** change comand for alias
* **nl nome-arquivo** counter how much lines have to nome-arquivo
* **wc -l nome-arquivo** counter how much lines have to nome-arquivo
* **wc -w nome-arquivo** counter how much words have to nome-arquivo
* **wc -c nome-arquivo** counter how much bytes have to nome-arquivo
* **wc -m nome-arquivo** counter how much charaters have to nome-arquivo
* **ls -F** show '/' next of each name directory
* **ls -a** show hidden files of directory (show '.' front of each name file/directory are hidden)
* **rm -r name-arquivo** erase nome-arquivo
* **cmp nome-arquivo-1 nome-arquivo-2** compare between two nome-arquivo-n
* **diff nome-arquivo-1 nome-arquivo-2** compare between two nome-arquivo-n
* **sort -n nome-arquivo-num** show ordener content os nome-arquivo-num
* **last reboot** show information about history to reboot
* **route -n** show table router ip the our kernel
* **time** show how much process time
* **time traceroute address** show how much process time command traceroute
* **uptime** time of system when are running
* **cowsay 'msg'** show msg with funny cow
* **cowsay -d 'msg'** show msg with funny cow
* **cowsay -g 'msg'** show msg with funny cow
* **cowsay -f 'msg'** show msg with funny cow
* **cowsay -f tux 'msg'** show msg with linux logo
* **cowsay -f vader 'msg'** show msg with funny cow
* **cowsay -f vader-koala 'msg'** show msg with funny koala
* **xcowsay 'msg'** show msg with funny cow 3d
* **cmatrix** show effect matrix in our screen
* **init 0** shutdown
* **telinit 0** shutdown
* **halt** get password, for next, shutdown
* **logout** shutdown session
* **seq 1 10** show sequence in the screen
* **whereis** show path to nome-file and your manual
* **which** show path of nome-file

[bellard.org](https://bellard.org/jslinux/) where we can try this command.
