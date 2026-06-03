# Customer CRUD API

API RESTful completa para cadastro e gerenciamento de clientes, com **Spring Boot**, **MySQL** e arquitetura em camadas.

## Tecnologias

- Java 17
- Spring Boot 3.2
- Spring Data JPA / Hibernate
- MySQL 8
- Bean Validation
- Maven
- Docker / Docker Compose
- Swagger / OpenAPI 3

## Funcionalidades

- CRUD completo: criar, listar, buscar, atualizar e remover clientes
- Busca por nome (case-insensitive)
- Soft delete (desativação sem remover do banco)
- Validação de e-mail único por cliente
- Tratamento centralizado de exceções com HTTP status corretos
- Documentação automática com Swagger UI

## Como Executar

### Com Docker

```bash
docker-compose up --build
```

Acesse: http://localhost:8082/swagger-ui.html

## Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/api/customers` | Cadastrar cliente |
| GET | `/api/customers` | Listar todos |
| GET | `/api/customers/{id}` | Buscar por ID |
| GET | `/api/customers/search?name=` | Buscar por nome |
| PUT | `/api/customers/{id}` | Atualizar cliente |
| PATCH | `/api/customers/{id}/deactivate` | Desativar cliente |
| DELETE | `/api/customers/{id}` | Remover permanentemente |

## Estrutura

```
src/main/java/com/patryck/customers/
├── controller/   # CustomerController
├── service/      # CustomerService
├── repository/   # CustomerRepository
├── entity/       # Customer
├── dto/          # Request e Response DTOs
└── exception/    # CustomerNotFoundException, GlobalExceptionHandler
```

## Autor

**Patryck Martins Langsdorff** — Desenvolvedor Java Back End Junior

[![LinkedIn](https://img.shields.io/badge/LinkedIn-patryck--martins--langsdorff-blue)](https://www.linkedin.com/in/patryck-martins-langsdorff)
