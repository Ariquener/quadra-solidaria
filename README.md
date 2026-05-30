# ⚽ Quadra Solidária

Sistema web desenvolvido para gerenciamento de eventos esportivos, campeonatos, quadras e reservas comunitárias, com autenticação administrativa e integração com banco de dados.

O projeto foi desenvolvido como atividade acadêmica integrando **desenvolvimento web com framework**, **modelagem e manipulação de banco de dados** e **controle de versão com Git/GitHub**.

---

# Objetivo do Projeto

O **Quadra Solidária** foi criado com o objetivo de incentivar a participação esportiva da comunidade, oferecendo um sistema simples para gerenciamento de:

* Campeonatos
* Eventos esportivos
* Quadras
* Reservas
* Área administrativa

Além disso, o projeto demonstra a integração entre **frontend, backend e banco de dados relacional**.

---

# Tecnologias Utilizadas

As tecnologias utilizadas no desenvolvimento foram:

* **Java 21**
* **Spring Boot 3**
* **HTML5**
* **CSS3**
* **JavaScript**
* **Bootstrap 5**
* **MySQL**
* **JPA / Hibernate**
* **Maven**
* **Git e GitHub**

---

# Funcionalidades do Sistema

O sistema possui as seguintes funcionalidades:

* Página inicial responsiva
* Login administrativo
* Dashboard administrativo
* Autenticação simples de usuário
* Sistema de logout
* Integração com banco de dados MySQL
* Cadastro e manipulação de dados
* Consultas SQL
* Operações de inserção, atualização e remoção de dados

---

# Modelagem do Banco de Dados

O sistema foi modelado utilizando banco de dados relacional, contendo as entidades:

* Usuário
* Campeonato
* Evento
* Quadra
* Reserva

Relacionamentos implementados:

* Usuário → Reserva
* Quadra → Reserva
* Campeonato → Evento

O banco utiliza:

* Primary Key (PK)
* Foreign Key (FK)
* AUTO_INCREMENT
* NOT NULL
* UNIQUE

---

# Manipulação de Banco de Dados

Durante o desenvolvimento foram executadas operações SQL como:

### Inserção (INSERT)

* Cadastro de campeonatos
* Cadastro de usuários
* Cadastro de eventos

### Consulta (SELECT)

* Listagem de registros
* Filtros de informações

### Atualização (UPDATE)

* Alteração de dados cadastrados

### Remoção (DELETE)

* Exclusão de registros de teste

---

# Estrutura do Projeto

```txt
quadra-solidaria/
│
├── pom.xml
├── README.md
├── database.sql
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── quadrasolidaria/
│       │           ├── QuadraSolidariaApplication.java
│       │           └── SecurityConfig.java
│       │
│       └── resources/
│           ├── application.properties
│           └── static/
│               ├── index.html
│               ├── login.html
│               ├── dashboard.html
│               ├── style.css
│               ├── script.js
│               └── imagens
```

---

# Como Executar o Projeto

## 1. Clonar o repositório

```bash
git clone https://github.com/Ariquener/quadra-solidaria.git
```

## 2. Abrir o projeto

Abra no VS Code ou IDE Java.

## 3. Configurar banco MySQL

Criar o banco:

```sql
CREATE DATABASE quadra_solidaria;
```

Configurar o arquivo:

```properties
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quadra_solidaria
spring.datasource.username=admin
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 4. Executar aplicação

No terminal:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:

```txt
http://localhost:8080
```

---

# Controle de Versão

O projeto foi gerenciado utilizando **Git** e hospedado no **GitHub**, com commits organizados para acompanhar a evolução do sistema.

Exemplos de commits:

* feat: estrutura inicial do sistema
* feat: implementa login administrativo
* feat: integra banco de dados mysql
* fix: corrige fluxo de autenticação

---

# Melhorias Futuras

Melhorias previstas:

* Cadastro completo de usuários
* Reserva de quadras pela interface
* Painel administrativo avançado
* Segurança com autenticação real via Spring Security
* Persistência completa via JPA Repository

---

# Autor

**Ariquener Marques**

© 2026 — Quadra Solidária
