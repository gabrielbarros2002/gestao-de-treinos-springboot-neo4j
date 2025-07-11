# Backend - Gestão de Treinos

Este é o projeto backend da aplicação Gestão de Treinos, desenvolvido com Spring Boot e Neo4j.

## Requisitos

Antes de rodar a aplicação, é necessário ter instalado:

- Java 21 ou superior  
  https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows

- Apache Maven  
  https://maven.apache.org/download.cgi

- Neo4j Desktop 
  https://neo4j.com/download/

## Configuração do banco de dados

1. No Neo4j Desktop, crie um banco de dados com o nome: `gestao_de_treinos`

2. Configure um usuário com as seguintes credenciais:

- Usuário: `neo4j`
- Senha: `12345678`

Essas credenciais estão definidas no arquivo `src/main/resources/application.properties`. Caso utilize configurações diferentes, atualize este arquivo conforme necessário.

3. Importe o script `gestao_de_treinos_backup.dump`, localizado na raiz do projeto, para popular o banco de dados com dados iniciais.

## Compilação e Execução

1. Acesse o diretório raiz do projeto back-end no terminal.

2. Execute o seguinte comando para compilar o projeto e baixar as dependências:

3. Após a compilação, execute a aplicação com o comando: mvn clean install

4. Após a compilação, execute a aplicação com o comando: java -jar target/gestao-de-treinos-0.0.1-SNAPSHOT.jar
 
## Acesso à API

A aplicação será iniciada por padrão na porta 8081. O endereço base da API será: http://localhost:8081/gestao-de-treinos

Caso a porta esteja ocupada ou seja necessário alterar a configuração, edite o arquivo `application.properties`.

## Observações

- Certifique-se de que o serviço do Neo4j esteja em execução antes de iniciar a aplicação.
- Certifique-se de que o banco de dados `gestao_de_treinos` esteja em execução.
- O script `gestao_de_treinos_backup.dump` deve ser executado apenas uma vez para carga inicial dos dados.
