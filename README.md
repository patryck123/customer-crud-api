# 👥 Customer CRUD API

API RESTful para cadastro e gerenciamento completo de clientes.

## 📋 Sobre o Projeto

Projeto ideal para aprender os fundamentos do desenvolvimento back-end com Spring Boot. Implementa as 4 operações básicas de um sistema (CRUD), com arquitetura em camadas, tratamento de erros personalizado e validação de dados.

## ✨ Funcionalidades

- ✅ Cadastrar cliente (nome, e-mail, CPF, telefone, endereço)
- ✅ Listar todos os clientes
- ✅ Buscar cliente por ID
- ✅ Buscar cliente por e-mail
- ✅ Atualizar dados do cliente
- ✅ Excluir cliente
- ✅ Validação de campos obrigatórios
- ✅ Tratamento de exceções personalizado
- ✅ Resposta de erro com mensagem clara

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/api/customers` | Listar todos os clientes |
| GET | `/api/customers/{id}` | Buscar por ID |
| GET | `/api/customers/email/{email}` | Buscar por e-mail |
| POST | `/api/customers` | Cadastrar novo cliente |
| PUT | `/api/customers/{id}` | Atualizar cliente |
| DELETE | `/api/customers/{id}` | Excluir cliente |

## 🛠️ Tecnologias

- Java 17
- Spring Boot 3.2
- Spring MVC
- Spring Data JPA
- MySQL
- Maven
- Docker & Docker Compose
- Lombok
- Bean Validation

## ▶️ Como Executar

```bash
docker-compose up -d
./mvnw spring-boot:run
```
