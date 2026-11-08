# Banking Management System

<div align="center">

**A console-based Java mini project for managing customer bank accounts and transactions.**

[View Repository](https://github.com/mudasirsoomro2025-ops/banking-management-system)

![Java](https://img.shields.io/badge/Java-21%2B-orange?logo=openjdk&logoColor=white)
![Application](https://img.shields.io/badge/Application-Console%20Based-1f6feb)
![Storage](https://img.shields.io/badge/Storage-File%20Persistence-2ea44f)
![Status](https://img.shields.io/badge/Status-Completed-success)

</div>

## Overview

**Banking Management System** is an academic Java mini project that simulates essential banking operations through a simple, menu-driven console interface. It is designed to demonstrate core Java programming concepts in a practical application, including classes and objects, encapsulation, collections, input validation, authentication, and file handling.

The application starts with sample accounts on the first run and automatically saves account changes to a local data file. When the program is started again, the saved accounts and updated balances are loaded automatically.

## Features

| Area | Functionality |
|---|---|
| Authentication | Customer login using account number and password |
| Account management | Create a new account with duplicate-number validation |
| Transactions | Deposit and withdraw money with amount validation |
| Balance | Check the current account balance |
| Account details | View an individual account's information |
| Account directory | Display all available accounts |
| Persistence | Save and load accounts using Java serialization |
| Validation | Handle invalid input, insufficient balance, and invalid credentials |

## Application Flow

```text
Start Application
       │
       ├── Load saved accounts
       │       └── If no saved data exists, create sample accounts
       │
       └── Main Menu
               ├── Customer Login
               │       ├── Deposit Money
               │       ├── Withdraw Money
               │       ├── Check Balance
               │       ├── Account Details
               │       └── Logout
               ├── Create New Account
               ├── Search Account Details
               ├── Display All Accounts
               └── Exit and Save Data
```

## Technology Stack

- **Language:** Java 21+
- **User interface:** Console-based menu
- **Collections:** `ArrayList`
- **Persistence:** Java object serialization
- **Development environment:** Eclipse IDE or any Java-compatible IDE
- **Build:** Standard Java compiler (`javac`)

## Project Structure

```text
banking-management-system/
├── README.md
├── .gitignore
├── docs/
│   └── TESTING.md
└── src/
    └── banks/
        └── Main.java
```

## Run in Eclipse

1. Open Eclipse and select **File → New → Java Project**.
2. Create a package named `banks` inside the `src` folder.
3. Place `Main.java` inside `src/banks/`.
4. Confirm that the first line is:

   ```java
   package banks;
   ```

5. Right-click `Main.java` and select **Run As → Java Application**.

The program creates `bank_accounts.dat` in its working directory when account data is saved. This generated file is intentionally excluded from Git using `.gitignore`.

## Run from the Terminal

From the project root, compile the source into a separate output folder and start the application:

```bash
mkdir -p bin
javac -d bin src/banks/Main.java
java -cp bin banks.Main
```

## Sample Login

The first run creates sample accounts. One sample login is:

| Field | Value |
|---|---|
| Account number | `1001` |
| Password | `Munwar123` |

> These credentials are included only as sample data for this educational console application. A production banking application would use secure password hashing, protected secrets, a database, and role-based access control.

## Testing and Verification

The project has been compiled with `javac -Xlint:all` without compiler warnings. The verified flows include successful and unsuccessful login, account creation, duplicate account validation, account search, invalid transaction amounts, deposits, insufficient-balance handling, withdrawals, displaying all accounts, clean exit, and persistence after restarting the application.

Detailed verification notes are available in [`docs/TESTING.md`](docs/TESTING.md).

## Learning Objectives

This project provides practice with:

- Designing classes and constructors
- Applying encapsulation with private fields and public methods
- Using `ArrayList` to manage multiple objects
- Building menu-driven console applications
- Validating numeric and text input
- Handling file I/O and serialization
- Organizing a Java project using packages
- Testing normal and invalid user flows

## Future Improvements

Possible next steps for extending the project include:

- Replace plain-text passwords with secure password hashing
- Store accounts in a relational database
- Add administrator authentication and permissions
- Add transaction history and account statements
- Use `BigDecimal` instead of `double` for financial calculations
- Add unit tests with JUnit
- Separate the user interface, business logic, and data-access layers
- Add a graphical or web-based interface

## Project Status

This repository contains a completed Java console-based mini project suitable for academic demonstration and further enhancement.

## License

This project is provided for educational purposes. You may adapt and extend it for learning, coursework, and demonstration.
