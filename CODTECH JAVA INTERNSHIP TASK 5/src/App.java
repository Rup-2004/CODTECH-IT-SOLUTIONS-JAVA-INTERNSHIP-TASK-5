import java.util.Scanner;

// Class representing a bank account
class Account {
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    private Transaction[] transactionHistory;
    private int transactionCount;

    // Constructor
    public Account(String accountHolderName, String accountNumber, int maxTransactions) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;  // Default balance is 0
        this.transactionHistory = new Transaction[maxTransactions];
        this.transactionCount = 0;
    }

    // Getters and setters
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit", amount);
            System.out.println("Deposited $" + amount + " successfully.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrawal", amount);
            System.out.println("Withdrew $" + amount + " successfully.");
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Method to transfer money
    public void transfer(Account targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            targetAccount.balance += amount;
            addTransaction("Transfer to " + targetAccount.getAccountNumber(), amount);
            targetAccount.addTransaction("Transfer from " + this.accountNumber, amount);
            System.out.println("Transferred $" + amount + " to account " + targetAccount.getAccountNumber() + " successfully.");
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Method to add a transaction to the history
    private void addTransaction(String type, double amount) {
        if (transactionCount < transactionHistory.length) {
            transactionHistory[transactionCount++] = new Transaction(type, amount);
        } else {
            System.out.println("Transaction history is full!");
        }
    }

    // Method to view transaction history
    public void viewTransactionHistory() {
        if (transactionCount == 0) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (int i = 0; i < transactionCount; i++) {
                System.out.println(transactionHistory[i]);
            }
        }
    }

    // Method to update personal information
    public void updatePersonalInfo(String newName) {
        this.accountHolderName = newName;
        System.out.println("Account holder name updated to: " + newName);
    }
}

// Class representing a transaction (deposit, withdrawal, transfer)
class Transaction {
    private String type;
    private double amount;
    private String timestamp;

    // Constructor
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Amount: $" + amount + ", Date: " + timestamp;
    }
}

// Main class for the banking system
public class App {
    private Account[] accounts;
    private int accountCount;
    private int maxTransactionsPerAccount;
    private Scanner scanner;

    // Constructor
    public App(int maxAccounts, int maxTransactionsPerAccount) {
        this.accounts = new Account[maxAccounts];
        this.accountCount = 0;
        this.maxTransactionsPerAccount = maxTransactionsPerAccount;
        this.scanner = new Scanner(System.in);
    }

    // Method to create a new account
    public void createAccount() {
        if (accountCount < accounts.length) {
            System.out.print("Enter account holder name: ");
            String name = scanner.nextLine();
            String accountNumber = "ACC" + (accountCount + 1);  // Generate a simple account number
            accounts[accountCount++] = new Account(name, accountNumber, maxTransactionsPerAccount);
            System.out.println("Account created successfully. Account Number: " + accountNumber);
        } else {
            System.out.println("Cannot create more accounts. Maximum limit reached.");
        }
    }

    // Method to find an account by account number
    private Account findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    // Method to deposit funds
    public void depositFunds() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            account.deposit(amount);
        }
    }

    // Method to withdraw funds
    public void withdrawFunds() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            account.withdraw(amount);
        }
    }

    // Method to transfer funds between accounts
    public void transferFunds() {
        System.out.print("Enter your account number: ");
        String fromAccountNumber = scanner.nextLine();
        Account fromAccount = findAccount(fromAccountNumber);
        if (fromAccount != null) {
            System.out.print("Enter recipient account number: ");
            String toAccountNumber = scanner.nextLine();
            Account toAccount = findAccount(toAccountNumber);
            if (toAccount != null) {
                System.out.print("Enter transfer amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();  // Consume newline
                fromAccount.transfer(toAccount, amount);
            }
        }
    }

    // Method to view transaction history
    public void viewTransactionHistory() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.viewTransactionHistory();
        }
    }

    // Method to update personal information
    public void updatePersonalInfo() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter new account holder name: ");
            String newName = scanner.nextLine();
            account.updatePersonalInfo(newName);
        }
    }

    // Main menu for the banking system
    public void showMenu() {
        while (true) {
            System.out.println("\n--- Online Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Transaction History");
            System.out.println("6. Update Personal Information");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositFunds();
                    break;
                case 3:
                    withdrawFunds();
                    break;
                case 4:
                    transferFunds();
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
                    updatePersonalInfo();
                    break;
                case 7:
                    System.out.println("Thank you for using the Online Banking System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Main method to run the banking system
    public static void main(String[] args) {
        App bankSystem = new App(10, 20);  // Max 10 accounts, max 20 transactions per account
        bankSystem.showMenu();
    }
}

