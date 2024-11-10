# Projeto de Estudo: Sistema de Registro de Usuários

Este repositório contém um projeto de estudo focado em Spring Boot, onde é criada uma API RESTful para gerenciar produtos. O projeto usa PostgreSQL como banco de dados e é configurado com Maven para gerenciamento de dependências. Postman é utilizado para testar as requisições HTTP.


### Projeto desenvolvido na linguagem Java por:
- [Felipe Fonseca](https://github.com/lipefnsc)

## Descrição do Projeto

O objetivo deste projeto é estudar os conceitos do Spring Boot na criação de uma API RESTful para gerenciamento de produtos, utilizando PostgreSQL como banco de dados. A aplicação permite realizar operações CRUD (Create, Read, Update e Delete) nos produtos.O objetivo deste projeto é construir uma aplicação Java com um conjunto de testes unitários abrangente, aplicando conceitos como cobertura de testes, boas práticas de testes e as funcionalidades do JUnit. O projeto está estruturado com Maven para facilitar o gerenciamento das dependências.

## Tecnologias Utilizadas

- Java (versão 17+)
- Spring Boot (versão 3.0+)
- Maven
- PostgreSQL
- Postman

## Funcionalidades
- Registro de novos usuários
- Listagem de todos os usuários
- Busca de usuário por ID
- Atualização dos dados de um usuário
- Exclusão de um usuário

## Endpoints da API

| Método  | Endpoint         | Descrição                    |
|---------|------------------|------------------------------|
| POST    | `/users	`        | Registra um novo usuário     |
| GET ALL | `/users`      | Lista todos os usuários      |
| GET ONE | `/users/{id}` | Busca um usuário por ID      |
| UPDATE  | `/users/{id}` | Atualiza dados de um usuário |
| DELETE  | `/users/{id}` | Deleta um usuário            |

## Exemplo de JSON para criar um produto

```json
{
  "name": "Rafael Mendes",
  "email": "rafael.mendes@example.com",
  "age": 29,
  "height": "1.82"
}
```

## Uso

Para testar a aplicação, siga os passos:

1. Abra o Postman.
2. Use os endpoints descritos acima para enviar requisições HTTP para a API.
3. Acompanhe os resultados e verifique os dados no banco de dados PostgreSQL.

## Contato

[Felipe Fonseca - devfelipefonseca@outlook.com](mailto:devfelipefonseca@outlook.com)