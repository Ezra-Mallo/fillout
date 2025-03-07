import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Main class
public class Test1ATMSystem 
{
    public static void main(String[] args) 
    {
        ATM atm = new ATM();
        atm.startATM();
    }
}

// Account class representing a bank account
class Account 
{
    private String accountNumber;
    private String holderName;
    private double balance;

    public Account(String accountNumber, String holderName, double balance) 
    {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() 
    {
        return accountNumber;
    }

    public String getHolderName() 
    {
        return holderName;
    }

    public double getBalance() 
    {
        return balance;
    }

    // Deposit money into the account
    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money from the account
    public boolean withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining balance: $" + balance);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
            return false;
        }
    }

    // Check account balance
    public void checkBalance() 
    {
        System.out.println("Current balance: $" + balance);
    }
}

// ATM class managing multiple accounts
class ATM 
{
    private Map<String, Account> accounts;
    private Scanner scanner;

    public ATM() 
    {
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    // Method to create a new account
    public void createAccount() 
    {
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();

        if (accounts.containsKey(accNumber)) 
        {
            System.out.println("Account number already exists. Try again.");
            return;
        }

        System.out.print("Enter account holder's name: ");
        String holderName = scanner.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        accounts.put(accNumber, new Account(accNumber, holderName, initialBalance));
        System.out.println("Account created successfully!");
    }

    // Retrieve an account by account number
    public Account getAccount() 
    {
        System.out.print("Enter your account number: ");
        String accNumber = scanner.nextLine();

        if (accounts.containsKey(accNumber)) 
        {
            return accounts.get(accNumber);
        } else {
            System.out.println("Account not found. Please create an account first.");
            return null;
        }
    }

    // Display the main menu
    public void startATM() 
    {
        while (true) 
        {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 5) 
            {
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            }

            switch (choice) 
            {
                case 1:
                    createAccount();
                    break;
                case 2:
                    Account account = getAccount();
                    if (account != null) {
                        account.checkBalance();
                    }
                    break;
                case 3:
                    account = getAccount();
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        account.deposit(depositAmount);
                    }
                    break;
                case 4:
                    account = getAccount();
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        account.withdraw(withdrawAmount);
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}