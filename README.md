# Banking Management System

A console-based banking management system developed in Java as a mini project. The application demonstrates object-oriented programming, account authentication, transaction validation, and file-based data persistence using Java serialization.

## Features

- Customer login with account number and password
- Create a new bank account
- Deposit and withdraw money with validation
- Check account balance
- View individual account details
- Display all bank accounts
- Save and load account data automatically
- Handles invalid amounts, duplicate account numbers, insufficient balance, and invalid login attempts

## Technologies

- Java 21+
- Object-oriented programming
- Java Collections (`ArrayList`)
- Java Serialization
- Console-based user interface

## Project Structure

```text
src/
└── banks/
    └── Main.java
```

## Running in Eclipse

1. Open Eclipse and create a new **Java Project**.
2. Create the package `banks` inside the `src` folder.
3. Place `Main.java` inside `src/banks/`.
4. Right-click `Main.java` and select **Run As → Java Application**.

The first run creates ten sample accounts. Account data is stored in `bank_accounts.dat` in the program's working directory.

## Running from the terminal

```bash
javac -d bin src/banks/Main.java
java -cp bin banks.Main
```

## Sample Login

```text
Account Number: 1001
Password: Munwar123
```

## Testing

The application was compiled with `javac -Xlint:all` and tested through complete menu flows, including successful and unsuccessful authentication, account creation, duplicate-account validation, transaction validation, insufficient balance handling, account search, display of all accounts, clean exit, and persistence after restarting the application.

Detailed test notes are available in [`docs/TESTING.md`](docs/TESTING.md).

## Academic Mini Project

This project is suitable for demonstrating Java fundamentals, classes and objects, encapsulation, exception handling, collections, file handling, and menu-driven application design.
