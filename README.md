# Online Shopping System

A full-stack **Online Shopping System** developed using HTML, CSS, JavaScript, Java, Spring Boot, and a relational database. This project provides an online shopping experience where users can browse products, add items to their cart, and place demo orders.

## 🚀 Features

- **Product Listing:** Display available products with details and prices.
- **Product Management:** Support for managing product information.
- **Shopping Cart:** Add products to the cart and manage selected items.
- **Checkout:** Proceed through the checkout process.
- **Order Summary:** View order details after checkout.
- **Order Confirmation:** Confirm demo orders.
- **Reviews and Ratings:** Support for product feedback.
- **REST APIs:** Backend APIs developed using Spring Boot.
- **Database Integration:** Store product and order information.
- **Responsive Frontend:** User interface built with HTML, CSS, and JavaScript.

## 🛠️ Technologies Used

### Frontend
- HTML5
- CSS3
- JavaScript

### Backend
- Java
- Spring Boot
- Spring Data JPA
- REST APIs
- Maven

### Database
- Oracle Database (SQL*Plus), if configured
- MySQL, if configured

## 📁 Project Structure

```text
Online-Shopping-System/
├── src/
│   └── main/
│       ├── java/
│       │   └── ...
│       └── resources/
│           ├── static/
│           └── application.properties
├── pom.xml
└── README.md
```

## ⚙️ Prerequisites

Before running the project, install:

- JDK 17 or a compatible supported JDK
- Apache Maven
- Oracle Database or MySQL
- Git
- Visual Studio Code or IntelliJ IDEA

## 🔧 Database Configuration

Configure your database connection in:

`src/main/resources/application.properties`

Example configuration for Oracle Database:

```properties
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/XEPDB1
spring.datasource.username=YOUR_ORACLE_USERNAME
spring.datasource.password=YOUR_ORACLE_PASSWORD
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false
```

Replace the example service name, username, and password with your actual Oracle database details.

**Important:** For Oracle, ensure that the Oracle JDBC dependency is configured in `pom.xml`. If you use MySQL instead, configure the MySQL JDBC driver and connection properties.

Never upload your real database password to a public GitHub repository.

## ▶️ How to Run the Project

### Step 1: Clone the Repository

```bash
git clone https://github.com/2025SHIVAM/Online-Shopping-System.git
```

### Step 2: Open the Project Folder

```bash
cd Online-Shopping-System
```

### Step 3: Configure the Database

Update `application.properties` with the correct database URL, username, and password. Ensure your database service is running and the JDBC dependency matches your database.

### Step 4: Start the Application

```bash
mvn clean spring-boot:run
```

### Step 5: Open the Application

If the application is configured to run on port `8082`, open:

http://localhost:8082

## 🔗 Backend

The backend uses Spring Boot REST APIs to handle product information, cart operations, checkout, and orders. Refer to the project's controller classes for the exact API endpoints.

## 🎯 Project Objective

The objective of this project is to demonstrate full-stack development skills, including frontend development, Java programming, Spring Boot REST API development, database integration, and order-management workflows.

## 👨‍💻 Author

**Shivam Pathak**

B.Tech in Computer Science Engineering | 2025 Graduate

**Technical Skills:** Java, Spring Boot, REST APIs, SQL, HTML, CSS, JavaScript, MySQL, and Oracle Database.

## 📌 Disclaimer

This is an educational project. The checkout and payment workflow is intended for demonstration purposes only; it does not represent a real payment transaction unless a payment provider has been separately integrated.
