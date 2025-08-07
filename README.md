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
