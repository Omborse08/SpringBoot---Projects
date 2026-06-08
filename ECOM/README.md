# 🛒 ECOM - Product Management REST API

Welcome to **ECOM**, a clean, lightweight, and production-ready backend service designed to handle core e-commerce product catalog operations. Built using **Spring Boot**, **Java**, and **MySQL**, this project follows standard corporate engineering design patterns, ensuring a decoupling of concerns across a clean, layered architecture.

Whether you are looking to integrate a product system into a frontend application or exploring Spring Data JPA capabilities, this repository provides a rock-solid foundation.

---

## 🔥 Key Features

* **Complete CRUD Operations:** Create, retrieve, update, and delete product items seamlessly.
* **RESTful Standards:** Pure JSON-based request and response bodies mapped with accurate HTTP status codes (`201 Created`, `204 No Content`, `404 Not Found`).
* **Automated Persistence:** Object-Relational Mapping (ORM) powered by Hibernate with safe schema generation strategies.
* **Formatted SQL Logging:** Active query formatting enabled in the console to inspect raw SQL executions during testing.

---

## 🛠️ Tech Stack & Dependencies

* **Language:** Java (JDK 17+)
* **Framework:** Spring Boot 3.x
* **Database Driver:** MySQL Connector/J
* **Data Access:** Spring Data JPA / Hibernate
* **Utility:** Lombok (for zero boilerplate code)

---

## 📂 Layered Architecture

The codebase relies strictly on the separation of concerns across distinct packages:

```text
src/main/java/com/example/ECOM/
├── controller/  # Intercepts incoming HTTP requests and shapes responses
├── service/     # House of core business logic and computational workflows
├── repository/  # Interface extending JpaRepository for direct DB abstraction
└── model/       # The primary blueprint defining our database entity

```

## 📋 Sample Payload (POST / PUT Request Body)

{
  "title": "Mechanical Keyboard",
  "decs": "Tactile blue-switch RGB mechanical keyboard",
  "price": 4500,
  "quantity": 25
}

## ⚙️ Local Development Setup

CREATE DATABASE personal;
spring.datasource.url=jdbc:mysql://localhost:3306/YOUR DB
spring.datasource.username=your-username
spring.datasource.password=yout-password
mvn spring-boot:run

The application will automatically bind onto port 8080. You can test endpoints via Postman or cURL hitting http://localhost:8080/api/products.
