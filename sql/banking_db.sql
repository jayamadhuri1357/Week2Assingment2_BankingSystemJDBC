CREATE DATABASE banking_db;

USE banking_db;

CREATE TABLE customers (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    balance DOUBLE
);