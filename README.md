# Library Management System

This project is a Library Management System developed using MySQL. It includes entities for managing books, users, and loans.

## Table of Contents

- [Introduction](#introduction)
- [Database Schema](#database-schema)
- [Installation](#installation)
- [Usage](#usage)
- [Example Queries](#example-queries)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Library Management System is designed to help manage a library's inventory, user registrations, and book loans efficiently. The database schema includes three main entities: `Book`, `User`, and `Loan`.

## Database Schema

### Book Table

- **id** INT AUTO_INCREMENT PRIMARY KEY
- **title** VARCHAR(255) NOT NULL
- **author** VARCHAR(255) NOT NULL
- **publishedDate** DATE
- **ISBN** VARCHAR(13)
- **available** BOOLEAN
- **pageCount** INT 

### User Table

- **id**: INT AUTO_INCREMENT PRIMARY KEY
- **name**: VARCHAR(255) NOT NULL
- **email**: VARCHAR(255) NOT NULL
- **membershipDate**: DATE
- **active**: BOOLEAN
- **role**: INT

### Loan Table

- **id**: INT AUTO_INCREMENT PRIMARY KEY
- **bookId**: INT
- **userId**: INT
- **loanDate**: DATE
- **returnDate**: DATE
- **returned**: BOOLEAN
- **FOREIGN KEY (bookId)**: REFERENCES Book(id)
- **FOREIGN KEY (userId)**: REFERENCES User(id)

## Installation

To set up the Library Management System API, follow these steps:

    1. Clone the repository:
        ```bash
        git clone https://github.com/yourusername/library-management-api.git
        cd library-management-api
        ```
    
    2. Set up the MySQL database:
        ```sql
        CREATE DATABASE Library;
        USE Library;
    
        CREATE TABLE Book (
            book_id INT AUTO_INCREMENT PRIMARY KEY,
            title VARCHAR(255) NOT NULL,
            author VARCHAR(255) NOT NULL,
            genre VARCHAR(100),
            publication_date DATE,
            isbn VARCHAR(20) UNIQUE NOT NULL,
            quantity INT NOT NULL
        );
    
        CREATE TABLE User (
            user_id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(255) NOT NULL,
            address VARCHAR(255),
            phone VARCHAR(20),
            email VARCHAR(100) UNIQUE NOT NULL,
            registration_date DATE NOT NULL DEFAULT CURRENT_DATE
        );
    
        CREATE TABLE Loan (
            loan_id INT AUTO_INCREMENT PRIMARY KEY,
            book_id INT,
            user_id INT,
            loan_date DATE NOT NULL DEFAULT CURRENT_DATE,
            return_date DATE,
            status ENUM('loaned', 'returned') NOT NULL DEFAULT 'loaned',
            FOREIGN KEY (book_id) REFERENCES Book(book_id),
            FOREIGN KEY (user_id) REFERENCES User(user_id)
        );
        ```
    
    3. Update `application.properties` with your MySQL configuration:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/Library
        spring.datasource.username=root
        spring.datasource.password=yourpassword
        spring.jpa.hibernate.ddl-auto=update
        ```
    
    4. Build and run the project using Maven:
        ```bash
        mvn clean install
        mvn spring-boot:run
        ```

## Usage

The API provides endpoints for managing books, users, and loans. Below are the details of the available endpoints.

## API Endpoints

### Book
    
    - **Create Book**: `POST /api/books`
    - **Get All Books**: `GET /api/books`
    - **Get Book by ID**: `GET /api/books/{id}`
    - **Update Book**: `PUT /api/books/{id}`
    - **Delete Book**: `DELETE /api/books/{id}`
    
### User
    
    - **Create User**: `POST /api/users`
    - **Get All Users**: `GET /api/users`
    - **Get User by ID**: `GET /api/users/{id}`
    - **Update User**: `PUT /api/users/{id}`
    - **Delete User**: `DELETE /api/users/{id}`
    
### Loan
    
    - **Create Loan**: `POST /api/loans`
    - **Get All Loans**: `GET /api/loans`
    - **Get Loan by ID**: `GET /api/loans/{id}`
    - **Update Loan**: `PUT /api/loans/{id}`
    - **Delete Loan**: `DELETE /api/loans/{id}`
    
## Example Requests

### Create a Book

    ```bash
    curl -X POST http://localhost:8080/api/books -H "Content-Type: application/json" -d '{
    "title": "The Odyssey",
    "author": "Homer",
    "publishedDate": "1967-06-05",
    "isbn": "978-84-670-5005-9",
    "available": false,
    "pageCount": 448 
    }'

### Create a User

    curl -X POST http://localhost:8080/api/users -H "Content-Type: application/json" -d '{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "membershipDate": "2023-05-05",
    "active": false,
    "role": 1    
    }'

### Create a Loan

    curl -X POST http://localhost:8080/api/loans -H "Content-Type: application/json" -d '{
    "book_id": 1,
    "user_id": 1,
    "loanDate": "2024-05-01",
    "returnDate": "2024-05-15",
    "returned": true
    }'


