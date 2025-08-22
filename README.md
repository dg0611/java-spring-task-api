# 📋 List API - Gerenciador de Tarefas

Este é um projeto Spring Boot que fornece uma API REST para gerenciamento de tarefas, com autenticação baseada em JWT.

## 🚀 Funcionalidades

- 🔐 Login com autenticação JWT e senha criptografada com BCrypt
- 📄 CRUD de tarefas
- ✅ Listagem de tarefas concluídas
- 🕓 Listagem de tarefas pendentes

---

## 📂 Estrutura do Projeto

```
src/
├── config/              # Configurações de segurança, filtros e dados iniciais
├── controller/          # Controllers REST (User, Tarefa, etc.)
├── dto/                 # Data Transfer Objects
├── mapper/              # Mapeamento de entidades
├── model/               # Modelos JPA (Tarefa, Usuário)
├── repository/          # Repositórios Spring Data JPA
└── resources/
    └── application.properties
```
## 🧱 Padrão de Projeto Utilizado

O projeto segue o padrão **Arquitetura em Camadas (Layered Architecture)**, organizando as responsabilidades em:

- `Controller` → recebe e trata as requisições HTTP.
- `Service` → contém a lógica de negócio.
- `Repository` → faz acesso ao banco de dados com Spring Data JPA.
- `DTO` → objetos para transferência de dados entre as camadas.
- `Mapper` → responsável pela conversão entre entidades e DTOs.
- `Model` → entidades persistidas no banco.


---

## ⚙️ Pré-requisitos

- Java 17+
- Maven 3.x
- IDE (IntelliJ, VSCode, etc.)

---

## 🛠️ Configuração e Execução

### 1. Clone o projeto

```bash
git clone https://github.com/seu-usuario/list-api.git
cd list-api
```

### 2. Configure o `application.properties`

O projeto já vem com o banco de dados H2 configurado. Para que o sistema funcione corretamente, **você precisa definir uma chave secreta para o JWT** no arquivo:

```properties
# application.properties

jwt.secret=sua-chave-secreta-aqui
```

> 🔐 Escolha uma string aleatória forte como segredo para assinar os tokens JWT com pelo menmos 36 caracteres.

### 3. Execute o projeto

```bash
./mvnw spring-boot:run
```

ou se estiver usando o IntelliJ:

- Vá até a classe `ListApiApplication.java`
- Clique com o botão direito > `Run`

### 4. Acesse os recursos

- API: `http://localhost:8080`
- Console H2: `http://localhost:8080/h2-console`
    - JDBC URL: `jdbc:h2:mem:todo`
    - Usuário: `sa`
    - Senha: *(em branco)*

---

## 🧪 Endpoints Principais

### Autenticação

```http
POST /auth
```

Corpo:

```json
{
  "username": "seu_usuario",
  "password": "sua_senha"
}
```

Retorno:

```json
{
  "token": "jwt-token"
}
```

### Tarefas

- `GET /tarefa` → Listar todas
- `POST /tarefa` → Cadastrar tarefa
- `GET /tarefa/{id}` → Buscar por ID
- `DELETE /tarefa/{id}` → Deletar tarefa
- `GET /tarefa/concluidas` → Listar concluídas
- `GET /tarefa/pendentes` → Listar pendentes

> ⚠️ Todos os endpoints de tarefa exigem autenticação via JWT no header `Authorization: Bearer {token}`.

---

## 🧰 Tecnologias Usadas

- Spring Boot
- Spring Security
- JWT
- Criptografia com BCrypt
- H2 Database
- Maven

---

## 📝 Notas

- O banco é em memória (H2) e reinicia a cada execução.
- JWT expira conforme configurado no código (ajustável).
- Código organizado em camadas para facilitar manutenção e testes.

---

## 👨‍💻 Autor

Desenvolvido por Diego Gonçalves.

---
