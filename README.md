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

To set up the Library Management System database, follow these steps:

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/library-management-system.git
    cd library-management-system
    ```


