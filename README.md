# JDBC CRUD Operations in Java

This project demonstrates basic **CRUD (Create, Read, Update, Delete)** operations using **Java** and **JDBC** with a **MySQL** database.

## 📌 Features

- Connect to MySQL database using JDBC
- Perform Create, Read, Update, and Delete operations
- Well-structured code with separation of concerns
- Uses PreparedStatement to prevent SQL injection


## 💻 Technologies Used

- Java
- JDBC
- MySQL
- Maven (if applicable)

## ⚙️ Setup Instructions

### Prerequisites

- JDK 8 or above
- MySQL server running
- MySQL Workbench (optional)
- IDE (IntelliJ, Eclipse, VS Code)

### Database Setup

1. Create a MySQL database and table:

sql
CREATE DATABASE jdbc_demo;

USE jdbc_demo;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    country VARCHAR(100)
);

2. Update your DB credentials in DBConnection.java:

private static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo";
private static final String USER = "your_mysql_username";
private static final String PASSWORD = "your_mysql_password";



🧑‍💻 Author 
<br>
khelan sahu