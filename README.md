# DesafioPubFuture

Neste projeto foi utilizado apenas a linguagem java com seus frameworks e apis, tais como: Spring boot MVC, Spring Web, Hibernate, Jpa.
Foi utilizado o Gerenciador de pacotes Maven e para o banco de dados relacional foi utilizado o MySql.
Para Consultar a documentação do projeto, basta ir na pasta /doc.
 <br />O projeto está somente em formato REST API, sendo possível consumir seu end-point através do POSTMAN para realizar os testes.

# Para usar a aplicação deve cumprir os seguintes requisitos:

Java 8

Maven 3 ou 5

JUnit 5

MySql - XAMP ou outro

Gitbash para usuários de Windows

Terá que ser criado o banco de dados com o script .sql em um SGBD de sua escolha que foi disponibilizado no repositório.

Os seguintes links podem ser úteis:

https://dicasdejava.com.br/como-instalar-o-maven-no-windows/

https://www.java.com/pt-BR/download/manual.jsp
# Comandos:

git clone projeto
  
cd projeto

mvn clean install(É preciso também iniciar o mysql.)
  
Basta ir na pasta target e dar dois cliques no aplicativo .jar que foi criado.
  
# Para testes no POSTMAN.

### Consulta de contas, despesas, receitas ->

Exemplo:
GET: localhost:8080/api/v1/contas
  
### Consulta de contas, despesas e receitas por ID ->

Exemplo:
GET: localhost:8080/api/v1/contas/1
  
### Cadastro de contas, despesas e receitas ->

Exemplo
POST: localhost:8080/api/v1/contas

É necessário colocar os dados do JSON nessa area do POSTMAN,
informar ID é opcional.
  
![postmanpost](https://user-images.githubusercontent.com/45194959/149731282-9663ac71-d6cc-4e83-abe2-49dc7bcd0711.png)

### Edição de contas, despesas e receitas ->

Segue a mesma lógica da instrução da imagem acima.
É Preciso informar o id

Exemplo: 
PUT: localhost:8080/api/v1/contas/1

### Deleção de contas, despesas e receitas ->

É Preciso informar o id

DELETE: localhost:8080/api/v1/contas/1

# XD
