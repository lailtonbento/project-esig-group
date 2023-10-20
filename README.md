﻿# Projeto Task Esig Group

## Tecnologias usadas:

- a) Java 17 com Spring Boot
- b) Angular 16
- c) Bootstrap 5
- d) Docker-Compose
- e) PostgreSQL
- f) Spring Security OAuth (JWT Token)
- g) Spring Jpa/Hibernate
- h) Swagger (OpenAPI)

## Inicialização do projeto
## API backend:

- Utilizando uma IDE de sua preferencia, abra o projeto, modifique a base do banco de dados para uma de sua preferencia. A modificacao da base pode ser feita no arquivo:
  - application.yml e compose.yml

- Se preferir, utilize Docker Compose para iniciar um container que contem um serviço do postgreSQL:


    docker-compose up
Em seguida, rode o projeto pela IDE.


## Angular


    npm run start


### Explicacao das tecnologias usadas:

- a),d),e),f),g),h) Utilizando Java com Spring para criar uma API REST, foi utilizado os conceitos de SOLID e clean code para uma maior legibilidade e manutenabilidade do codigo, foi utilizado Spring Security para a autenticacao e autorizacao dos recursos REST, foi utilizado Hibernate para as implementacoes especificadas do JPA, foi utilizado Swagger para a documentacao dos recursos da API


- b),c) Foi utilizado Angular e Bootstrap para lidar com a interface do usuario que consome os recursos da API
  

