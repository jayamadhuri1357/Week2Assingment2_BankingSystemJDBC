# Banking System using JDBC

## Project Description

This project is a simple Banking System developed using Java, JDBC, and MySQL. It demonstrates database connectivity, CRUD operations, transaction management, exception handling, and Object-Oriented Programming concepts.

---

## Features

* Add Customer Account
* View Customer Records
* Update Customer Balance
* Delete Customer Account
* Check Existing Customer ID
* Money Transfer Between Accounts
* JDBC Connectivity with MySQL
* Transaction Management
* Exception Handling

---

## Technologies Used

* Java
* JDBC (Java Database Connectivity)
* MySQL Database
* MySQL Connector/J
* VS Code

---

## Project Structure

```text
BankingSystemJDBC
│
├── src
│   ├── Customer.java
│   ├── DBConnection.java
│   ├── CustomerDAO.java
│   ├── BankingService.java
│   └── Main.java
│
├── sql
│   └── banking_db.sql
│
├── lib
│   └── mysql-connector-j-9.7.0.jar
│
└── README.md
```

---

## Database Setup

### Step 1: Create Database

Run the following SQL commands in MySQL Workbench:

```sql
CREATE DATABASE banking_db;

USE banking_db;

CREATE TABLE customers (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    balance DOUBLE
);
```

---

## JDBC Configuration

Update the database credentials in `DBConnection.java`:

```java
private static final String URL =
        "jdbc:mysql://localhost:3306/banking_db";

private static final String USER = "root";

private static final String PASSWORD = "your_password";
```

---

## Compile the Project

Open terminal inside the `src` folder and run:

```cmd
javac -cp ".;..\lib\mysql-connector-j-9.7.0.jar" *.java
```

---

## Run the Project

```cmd
java -cp ".;..\lib\mysql-connector-j-9.7.0.jar" Main
```

---

## Sample Output

```text
===== Banking System =====

Enter Customer ID: 1
Enter Customer Name: Jaya
Enter Initial Balance: 10000

Customer Added

Customer Records:
1 Jaya 10000.0
```

---

## OOP Concepts Used

* Class and Object
* Constructor
* Encapsulation
* Data Hiding

---

## JDBC Concepts Used

* DriverManager
* Connection
* PreparedStatement
* Statement
* ResultSet

---

## Transaction Management

The `BankingService` class demonstrates transaction management by transferring money between customer accounts.

```java
con.setAutoCommit(false);
con.commit();
```

This ensures that both debit and credit operations are executed as a single transaction.

---

