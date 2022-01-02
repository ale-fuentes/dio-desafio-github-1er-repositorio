# Diretórios e Comandos Essenciais
![](https://img.shields.io/badge/tutor-Bruno_de_Campos_Dias.-informational?style=flat&logoColor=white&color=cdcdcd)

## comandos para manipulação de arquivos e textos e redirecionamento

* **nano** editor de texto
<br/>
some comand of nano:
* **^ G** (F1) apresenta o arquivo de ajuda
* **^ X** (F2) fecha o buffer atual / sai do nano
* **^ O** (F3) salva em disco
* **^ J** justificar a linha
* **alt U** desfazer alteração
* **alt E** refazer alteração
* **alt A** marca texto
* **alt 6** copia texto
* **^ U** cola texto
* **^ `\`** subtituir
* **^ O** salvar

**comandos**

* **touch name-file** create new file.
* **cat nome-arquivo** visualizar o conteudo do arquivo
* **tac nome-arquivo** visualiza o conteudo do arquivo invertido
* **head nome-arquivo** visualiza as 10 primeiras linhas
* **tail nome-arquivo** visualiza as 10 ultimas linhas


* **cal** visualiza el calendario do mes atual. pode se colocar o ano como parametro, permitindo assim visualizar o calendario do ano indicado.
* **date** visualiza a data

* **grep** para busqueda dentro de um conteudo. exemplos:

```
# find word 'linux'
tail geralcontent.txt | grep linux
```

* **file** for know what type is some file.
* **whatis some-comand** little help about 'some-command' 
* **find path nome-arquivo** searching nome-arquivo inner path.  example:
```
# the simbol ~ are reference to personal path
find ~ month-may.txt
```

**comando de redirecinamento**

* **|** pipe comando para concatenar açoes. exemplos:

with **wmore**
```
# show using pagination, 'more' can see more line with push key
cat test.txt | more
```
with **less**
```
# show ussing pagination, 'less' show two point for wait actions
cat text.txt | less
```

* **&** concatenation instructions. the show aren't together exemples:

```
cat calendar.txt & month_july.txt
```
* **&&** concatenation instructions. the show are together. Second command are runing if first command is success. exemples:

```
cat calendar.txt && month_july.txt
```

* **>** pipe de saida. crea novo conteudo.
exemplos:
```
tail source.txt > target.txt
```
```
cal > currentcalendar.txt
```
```
cal 2020 > calendar_july.txt
```

* **>>** pipe adicionando no final o novo conteudo. exemplos:
```
date >> currentcalendar.txt
```
* **<** Direcina a entrada de um arquivo para a saída de um comando

### exercícios de revisão

1) Crie uma pasta de nome Exercícios e Acesse a mesma
2) Crie um arquivo vazio de nome lista_nomes.txt
3) Abra este arquivo com o Editor Nano
4) Digite 20 Nomes de Pessoas Conhecidas incluindo o seu, pulando de linha para cada nome inserido.
5) Salve o arquivo
6) Exiba os 10 primeiros Nomes da Lista
7) Exiba os 10 ultimos Nomes da Lista
8) Procure no texto o seu nome
9) Crie um Arquivo chamado setembro.txt com a saida do comando cal.
10) Adicione o conteúdo do arquivo setembro.txt ao arquivo lista_nomes.txt
11) Exiba o arquivo lista_nomes.txt com paginação
12) Exiba o caminho do arquivos setembro.txt
13) Exiba o tipo do arquivo lista_nomes.txt
14) Exiba a explicação do comando ls
15) Renomeie o Arquivo lista_nomes.txt para arquivo.txt
16) Limpe o Terminal
17) Saia do Terminal

[guiafoca.org](https://www.guiafoca.org/)


## diretórios do linux e comandos de sistema

* **/bin/** binarios principais dos usuários
* **/boot/** arquivos do sistema de boot
* **/dev/** arquivos de dispositivos
* **/etc/** arquivos de configuração do sistema
* **/home/** diretório dos usuários comuns do sistema
* **/lib/** bibliotecas essemciais do sistema e os módulos do kernel
* **/media/** diretório de montagem e dispositivos
* **/mnt/** diretório de montagem de dispositivos - mesmo que "media"
* **/opt/** diretório de programas não oficiais da distribuição ou por conta do usuário
* **/sbin/** armazena arquivos executáveis que re´resentam comandos administrativos. exemplo: shutdown
* **/srv/** diretório para dados de serviços fornecidos pelo sistema
* **/tmp/** diretório para arquivos temporários
* **/usr/**segunda hierarquia do sistema, onde ficam os usuários comuns do sistema e programas 
* **/var/** diretório comm arquivos variáveis gerados pelos programas do sistema. exemplo: log, impressoras, e-mail e cache.
* **/root/** diretório do usuário root - o usuário root tem o total poder sobre o sistema
* **/proc/** diretório virtual controlado pelo kernel

**camndos**

* **lscpu** show all informationa about cpu
* **lspci** show all boards pci connected in the system
* **lsusb** show all usb connected in the system
* **lshw** show all information about hardware connecting with to system
* **lshw -short** show some information about hardware connecting with to system.
* **arch** architecture to kernel
* **uname** name of kernel
* **uname -r** version of kernel
* **uname -m** architecture to kernel
* **free** show memory and swap
* **du -h diretory** know all diretory and its capacity ussing
* **reboot** restar our system
* * **shutdown -r** restar our system
* **shutdown -h now** shutdown our system now

listing all users
```
cat /etc/passwd | more
```
listing memory info
```
cat /proc/meminfo
```
listing processor info
```
cat /proc/cpuinfo
```

* **echo "msg"** show to msg in screen 
