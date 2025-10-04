# ExpenseWise – Personal Finance Tracker

**ExpenseWise** is a backend application for managing personal finances, built using **Java**, **Spring Boot**, and **PostgreSQL**. It provides a robust, secure, and scalable API to manage users, transactions, and categories, along with authentication via **JWT**.

---

## Table of Contents

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Project Structure](#project-structure)  
- [Setup](#setup)  
- [Database](#database)  
- [Authentication](#authentication)  
- [API Endpoints](#api-endpoints)  
- [Exception Handling](#exception-handling)  
- [Future Improvements](#future-improvements)  

---

## Features

- **User management**: Create, update, delete users with unique email and username constraints.  
- **Transaction management**: Record and categorize expenses or income.  
- **Category management**: Define categories as either EXPENSE or INCOME.  
- **Authentication**: JWT-based login and registration with hashed passwords using BCrypt.  
- **RESTful API**: CRUD operations for users, transactions, and categories.  
- **DTOs**: Data Transfer Objects to control API responses and avoid exposing sensitive data.  
- **Global Exception Handling**: Unified error handling using `@ControllerAdvice`.  

---

## Tech Stack

- **Java 25**  
- **Spring Boot 3.x**  
- **Spring Data JPA / Hibernate**  
- **PostgreSQL**  
- **JWT for authentication**  
- **BCrypt for password hashing**  
- **Maven** for dependency management  

---

## Project Structure

src/main/java/com/nuno/expensewiseapi
│
├─ controller # REST controllers for handling HTTP requests
├─ dto # Data Transfer Objects for API responses
├─ mapper # Mapping entities to DTOs
├─ model # JPA entities (User, Transaction, Category)
├─ repository # Spring Data JPA repositories
├─ service # Business logic and service layer
├─ security # JWT utility and security configuration
└─ exception # Global exception handling classes


---

## Setup

1. Clone the repository:

```bash
git clone <repository-url>
cd expensewise-api
```
2. Create an application.properties file (ignored in Git) with your environment variables:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/expensewise
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
jwt.secret=your_secret_key
server.port=8080
```

3. Build and run the application:
```bash
mvn clean install
mvn spring-boot:run
```
