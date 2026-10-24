# OASIS INFOBYTE – JAVA DEVELOPMENT INTERNSHIP

## Task 3: ATM Interface

Developed by: Romeo C. Villar Jr.
Course: BS Computer Engineering
Year and Section: BSCPE-2A
Programming Language: Java
Project Type: Console-Based Application

---

### Project Description

The ATM Interface is a console-based banking simulation developed using Java and Object-Oriented Programming (OOP).

The application allows users to log in using their User ID and PIN and perform basic banking transactions, including viewing transaction history, withdrawing money, depositing money, and transferring funds between accounts.

This project demonstrates fundamental Java programming concepts, including encapsulation, classes and objects, methods, conditional statements, loops, switch-case, and ArrayList collections.

### Features

- User Authentication – Requires a valid User ID and PIN.
- Login Attempt Limit – Denies access after three incorrect login attempts.
- Transaction History – Displays transactions recorded during the current program session.
- Withdraw – Allows users to withdraw money after checking their available balance.
- Deposit – Adds money to the user's account balance.
- Transfer – Transfers money to another registered demo account.
- Balance Validation – Displays an "Insufficient Funds" message when the balance is insufficient.
- Transaction Logging – Stores transaction records in an ArrayList.
- Menu System – Uses a switch-case statement to process menu selections.
- Input Validation – Checks invalid amounts and unavailable recipient accounts.

### Technologies Used

- Java
- IntelliJ IDEA
- Java Standard Library
- Object-Oriented Programming (OOP)

### Demo Login Credentials

The following accounts are provided for testing the application.

User ID| PIN| Initial Balance
1001| 1234| ₱5,000.00
1002| 4321| ₱3,000.00

Note: These are demonstration accounts only. Do not use real banking credentials.

### Project Structure
```text
Java-Task3-ATMInterface/
├── src/
│   ├── Main.java
│   ├── ATM.java
│   ├── Account.java
│   ├── Transaction.java
│   └── Bank.java
├── screenshots/
└── README.md
```

### Java Classes

- Main – Initializes the bank, scanner, and ATM application.
- ATM – Handles login, the main menu, and banking operations.
- Account – Manages account information, balance, and transaction records.
- Transaction – Represents individual banking transactions.
- Bank – Manages registered accounts, authentication, and fund transfers.

### How to Run the Project

Using IntelliJ IDEA

1. Download or clone the project repository.
2. Open the project folder in IntelliJ IDEA.
3. Configure a compatible Java Development Kit (JDK).
4. Open "src/Main.java".
5. Run the "main()" method.
6. Enter one of the demo accounts' User ID and PIN.
7. Select an option from the ATM main menu.

### Using the Command Line

Make sure Java is installed and configured on your computer.

Compile the source files:

javac -d out src/*.java

Run the application:

java -cp out Main

### Concepts Demonstrated

- Classes and Objects
- Encapsulation
- Private Fields and Getters/Setters
- Constructors and Methods
- ArrayList Collections
- HashMap Collections
- If-Else Statements
- While and For Loops
- Switch-Case Statements
- Input Validation
- Basic Transaction Processing

### Limitations

- Account information and balances are stored in memory.
- Account balances and transaction history reset when the application restarts.
- Transaction history is maintained for the current program session.
- This application is an educational simulation and is not connected to a real banking system.

### Screenshots

Screenshots of the running application should be added to the "screenshots/" folder to demonstrate the implemented features, including successful login, banking transactions, transaction history, and access denial after three incorrect login attempts.

### Internship Task Information

Organization: OASIS INFOBYTE
Internship Track: Java Development
Task Number: Task 3
Project Title: ATM Interface

---

Developed as a Java programming project to practice object-oriented programming and basic banking transaction logic.