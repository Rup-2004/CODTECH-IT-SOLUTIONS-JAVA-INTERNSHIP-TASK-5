Online Banking System (Java)

Overview
This is a Java-based simulation of an Online Banking System that allows users to:

Create accounts.
Deposit and withdraw funds.
Transfer money between accounts.
View transaction history.
Update personal information.
This implementation uses fixed-size arrays  for managing multiple accounts and transactions. It simulates a basic banking system with key functionalities commonly found in real-world online banking applications.

Features
Account Creation: Users can create a new bank account with a unique account number.
Deposit Funds: Deposit money into an account.
Withdraw Funds: Withdraw money from an account with sufficient balance.
Transfer Funds: Transfer money between two accounts.
Transaction History: View the history of deposits, withdrawals, and transfers for an account.
Personal Information Update: Update the account holder's name.
Fixed-Size Arrays: The system has a fixed limit on the number of accounts and the number of transactions stored per account.


Technical Details
Programming Language: Java
Dependencies: No external libraries required.


Fixed Limits:
Maximum of 10 accounts.
Maximum of 20 transactions per account.



Class Structure

Account Class:
Represents an individual bank account.
Stores account holder name, account number, balance, and a fixed-size transaction history.
Methods:
deposit(): Deposits money into the account.
withdraw(): Withdraws money from the account.
transfer(): Transfers money to another account.
viewTransactionHistory(): Displays the account's transaction history.
updatePersonalInfo(): Updates the account holder's name.

Transaction Class:
Represents a single transaction.
Stores the type of transaction (Deposit, Withdrawal, Transfer), the amount, and a timestamp.

App Class:
Manages the entire banking system.
Handles user input and provides a menu-based interface.
Stores all accounts in a fixed-size array.
Main methods include:
createAccount(): Creates a new bank account.
depositFunds(): Deposits money into an account.
withdrawFunds(): Withdraws money from an account.
transferFunds(): Transfers money between accounts.
viewTransactionHistory(): Views transaction history for an account.
updatePersonalInfo(): Updates personal information (name).
showMenu(): Displays the main menu and allows users to interact with the system.



How to Run the Program
Compile the Program: Use the following command in your terminal/command prompt to compile the program:

bash
javac BankSystem.java
Run the Program: After compiling, run the program using the following command:

bash
java BankSystem

Menu Options: After starting the program, you'll see a menu with the following options:


--- Online Banking System ---
1. Create Account
2. Deposit Funds
3. Withdraw Funds
4. Transfer Funds
5. View Transaction History
6. Update Personal Information
7. Exit
Choose the appropriate option by entering the corresponding number and following the instructions.


Limitations
Fixed Number of Accounts: The system can only hold a maximum of 10 accounts.
Limited Transaction History: Each account can store up to 20 transactions. Once the limit is reached, no new transactions will be recorded.
No Persistent Storage: This program does not save data to a file or database. All account data is lost when the program is terminated.
Future Enhancements


In a future version of this project, we could:
Implement dynamic data structures like ArrayList to allow unlimited accounts and transactions.
Add persistent storage by saving account information to a file or a database.
Add features like password protection, account deletion, and interest calculation.
Implement graphical user interface (GUI) using Java Swing or JavaFX for a more interactive experience.



Example Usage

Creating an Account:
Enter account holder name: John Doe
Account created successfully. Account Number: ACC1
Depositing Funds:

Enter account number: ACC1
Enter deposit amount: 500
Deposited $500.0 successfully.
Withdrawing Funds:

Enter account number: ACC1
Enter withdrawal amount: 100
Withdrew $100.0 successfully.
Transferring Funds:

Enter your account number: ACC1
Enter recipient account number: ACC2
Enter transfer amount: 200
Transferred $200.0 to account ACC2 successfully.




