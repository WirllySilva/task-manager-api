# Task Manager API

A RESTful API for managing tasks, developed as part of the **Back-End Web Development** course at university.

## 📚 Project Description

This API allows you to create, retrieve, update, and delete tasks. Each task contains the following information:

- Task name
- Due date
- Responsible person

Developed with:
- Java + Spring Boot
- Spring Data JPA
- MySQL

## 📌 Requirements

- Java 17+
- Maven 3+
- MySQL Server
- Postman (for testing)

## 🚀 Endpoints

| Method | Endpoint           | Description             |
|--------|--------------------|-------------------------|
| POST   | `/tasks`           | Create a new task       |
| GET    | `/tasks`           | Retrieve all tasks      |
| GET    | `/tasks/{id}`      | Retrieve task by ID     |
| PUT    | `/tasks/{id}`      | Update an existing task |
| DELETE | `/tasks/{id}`      | Delete a task by ID     |

## 🧪 Test Data

When testing, please make sure one of the tasks includes:

```json
{
  "name": "Wirlly Pereira da Silva",
  "dueDate": "2025-09-01",
  "responsible": "Wirlly Pereira da Silva"
}
```
## 🔧 Setup Instructions

1. Clone the repository:
```
git clone https://github.com/your-username/task-manager-api.git
```

2. Open the project in your IDE.

3. Configure the MySQL database in
```
src/main/resources/application.properties.
```

4. Run the application using your IDE or:
```
./mvnw spring-boot:run
```

## 📬 Contact
Developed by Wirlly Pereira da Silva
Uninter RU: 4645662
---

## ✅ 2. Spring Initializr Setup

📦 Link gerado com as dependências corretas:

👉 [Abrir projeto no Spring Initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.0&packaging=jar&jvmVersion=17&groupId=com.taskmanager&artifactId=task-manager-api&name=task-manager-api&description=Task%20Manager%20REST%20API&packageName=com.taskmanager&dependencies=web,data-jpa,mysql)

**Dependências incluídas:**
- Spring Web
- Spring Data JPA
- MySQL Driver

Baixe o `.zip`, extraia e importe no IntelliJ ou VS Code com suporte a Spring Boot.

---

## ✅ 3. Diagrama de Classes UML (código PlantUML)

```plantuml
@startuml TaskManagerAPI

package "Model" {
  class Task {
    - Long id
    - String name
    - LocalDate dueDate
    - String responsible
  }
}

package "Repository" {
  interface TaskRepository {
    + save(Task): Task
    + findAll(): List<Task>
    + findById(Long): Optional<Task>
    + deleteById(Long): void
  }
}

package "Controller" {
  class TaskController {
    + createTask(Task): ResponseEntity<Task>
    + getAllTasks(): ResponseEntity<List<Task>>
    + getTaskById(Long): ResponseEntity<Task>
    + updateTask(Long, Task): ResponseEntity<Task>
    + deleteTask(Long): ResponseEntity<Void>
  }
}

TaskRepository --> Task
TaskController --> TaskRepository

@enduml

