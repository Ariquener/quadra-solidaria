# ⚽ Quadra Solidária

Sistema web para gerenciamento comunitário de quadras esportivas, eventos e campeonatos, com foco em inclusão social, organização esportiva e facilidade de reserva de espaços.

O projeto permite que usuários realizem reservas de quadras, acompanhem campeonatos, visualizem eventos esportivos e fortaleçam a participação comunitária através do esporte.

---

## 📌 Objetivo do Projeto

O **Quadra Solidária** foi desenvolvido com o propósito de oferecer uma plataforma simples e acessível para:

* Reservar quadras esportivas
* Gerenciar campeonatos
* Divulgar eventos esportivos
* Promover integração social através do esporte
* Facilitar a administração dos espaços comunitários

---

## 🚀 Funcionalidades

### 👤 Usuário

* Visualização de eventos esportivos
* Consulta de campeonatos
* Reserva de quadras
* Seleção de horários disponíveis
* Bloqueio automático de horários já reservados
* Interface responsiva para desktop e mobile

### 🔐 Administração(Em construção)

* Login administrativo
* Dashboard administrativo
* Gerenciamento de informações do sistema

### ⚽ Sistema de Reservas

* Escolha da quadra
* Escolha da data
* Seleção apenas de horários disponíveis
* Validação de horários ocupados
* Integração com banco de dados

---

## 🛠️ Tecnologias Utilizadas

### Backend

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* Maven

### Frontend

* HTML5
* CSS3
* JavaScript
* Bootstrap 5
* Flatpickr

### Banco de Dados

* MySQL

---

## 🗄️ Estrutura do Banco de Dados

O sistema utiliza banco de dados relacional em **MySQL**, contendo entidades como:

* Reserva
* Quadra
* Evento
* Campeonato

Scripts SQL incluídos no projeto:

```sql
schema.sql
data.sql
operacoes.sql
```

---

## 📁 Estrutura do Projeto

```txt
src
 ├── main
 │   ├── java
 │   │   └── com.quadrasolidaria
 │   │       ├── config
 │   │       ├── controller
 │   │       ├── entity
 │   │       └── repository
 │   │
 │   └── resources
 │       ├── static
 │       ├── application.properties
 │       ├── schema.sql
 │       ├── data.sql
 │       └── operacoes.sql
```

---

## 🔌 Endpoints Principais

### Reservas

```http
GET /reservas
```

Lista todas as reservas.

```http
POST /reservas
```

Salva uma nova reserva.

Exemplo:

```json
{
  "nomeUsuario": "Ariquener",
  "dataReserva": "2026-06-03",
  "horario": "18:00",
  "quadra": {
    "idQuadra": 1
  }
}
```

```http
GET /reservas/ocupados
```

Retorna horários ocupados de uma quadra.

Exemplo:

```http
/reservas/ocupados?data=2026-06-03&quadraId=1
```

---

## ▶️ Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/Ariquener/quadra-solidaria.git
```

### 2. Entrar na pasta

```bash
cd quadra-solidaria
```

### 3. Configurar o banco MySQL

Crie um banco chamado:

```sql
quadra_solidaria
```

Configure o arquivo:

```properties
application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quadra_solidaria
spring.datasource.username=root
spring.datasource.password=suaSenha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Executar o projeto

No terminal:

```bash
mvn spring-boot:run
```

Ou execute pela IDE.

---

## 🌐 Acesso ao Sistema

Aplicação local:

```txt
http://localhost:8080
```

---

## 📱 Responsividade

O sistema foi desenvolvido com interface responsiva utilizando Bootstrap, permitindo utilização em:

* Desktop
* Tablet
* Smartphone

---

## 📚 Aprendizados do Projeto

Durante o desenvolvimento foram aplicados conceitos de:

* Programação Orientada a Objetos (POO)
* APIs REST
* Integração Frontend + Backend
* Banco de Dados Relacional
* Spring Boot
* JPA/Hibernate
* Versionamento com Git e GitHub
* Responsividade Web

---

## 👨‍💻 Autor

**Ariquener Marques**

GitHub:

https://github.com/Ariquener
