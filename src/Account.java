import java.util.*;

public class Account {
    //Variables
    double balance;
    double previousTransaction;
    String customerName;
    String customerID;

    //Constructor
    public Account(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    //Functions
    public void deposite(double amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
            previousTransaction = - amount;
        }
    }

    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + previousTransaction * -1);
        } else {
            System.out.println("No transaction occurred");
        }
    }

    public void calculateInterest(int years) {
        double interestRate = 0.02;
        double newBalance = balance * Math.pow(1.02, years);
        System.out.println("The current interest rate is: " + interestRate * 100 + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    public void showMenu() {
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println("What would you like to do?");
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdraw");
        System.out.println("D. View previous transaction");
        System.out.println("E. calculate new balance after specific years");
        System.out.println("F. Exit");

        char option = '~';

        while (option != 'F') {
            System.out.println("Enter an option then press return");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            while (s.length() != 1) {
                System.out.println("Invalid option, please enter option with one letter");
                Scanner scanner1 = new Scanner(System.in);
                s = scanner1.next();
            }
            option = s.charAt(0);
            option = Character.toUpperCase(option);

            if (option == 'A') {
                System.out.println("Your balance is: $" + balance);
            } else if (option == 'B') {
                System.out.println("Enter an amount to deposit: ");
                double amount = scanner.nextDouble();
                deposite(amount);
                System.out.println("Deposit complete");
            } else if (option == 'C') {
                System.out.println("Enter an amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                withdraw(withdrawAmount);
                System.out.println("Withdraw complete");
            } else if (option == 'D') {
                getPreviousTransaction();
            } else if (option == 'E') {
                System.out.println("How many years you want to keep the balance in your account?");
                int years = scanner.nextInt();
                calculateInterest(years);
            } else if (option != 'F') {
                System.out.println("Invalid option");
            }
        }
        System.out.println("You have exited, thank you.");
    }
}
