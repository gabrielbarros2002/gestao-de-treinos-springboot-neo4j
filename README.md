# Backend - Gestão de Treinos

Este é o projeto backend da aplicação Gestão de Treinos, desenvolvido com Spring Boot, JPA e PostgreSQL.

## Requisitos

Antes de rodar a aplicação, é necessário ter instalado:

- Java 21 ou superior  
  https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows

- Apache Maven  
  https://maven.apache.org/download.cgi

- PostgreSQL + PgAdmin  
  https://www.postgresql.org/download/

## Configuração do banco de dados

1. No PgAdmin, crie um banco de dados com o nome:

2. Configure um usuário com as seguintes credenciais:

- Usuário: `dev`
- Senha: `123456`

Essas credenciais estão definidas no arquivo `src/main/resources/application.properties`. Caso utilize configurações diferentes, atualize este arquivo conforme necessário.

3. Importe o script `backup.sql`, localizado na raiz do projeto, para popular o banco de dados com dados iniciais.

## Compilação e Execução

1. Acesse o diretório raiz do projeto back-end no terminal.

2. Execute o seguinte comando para compilar o projeto e baixar as dependências:

3. Após a compilação, execute a aplicação com o comando: mvn clean install

4. Após a compilação, execute a aplicação com o comando: java -jar target/gestao-de-treinos-0.0.1-SNAPSHOT.jar
 
## Acesso à API

A aplicação será iniciada por padrão na porta 8081. O endereço base da API será: http://localhost:8081/gestao-de-treinos

Caso a porta esteja ocupada ou seja necessário alterar a configuração, edite o arquivo `application.properties`.

## Observações

- Certifique-se de que o serviço do PostgreSQL esteja em execução antes de iniciar a aplicação.
- O script `backup.sql` deve ser executado apenas uma vez para carga inicial dos dados.







