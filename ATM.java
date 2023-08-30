import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Interface");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            if (choice == 1) {  // Withdraw
                System.out.print("Enter the amount to withdraw: ");
                double amount = scanner.nextDouble();
                if (bankAccount.withdraw(amount)) {
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Insufficient balance or invalid amount.");
                }

            } else if (choice == 2) {  // Deposit
                System.out.print("Enter the amount to deposit: ");
                double amount = scanner.nextDouble();
                if (bankAccount.deposit(amount)) {
                    System.out.println("Deposit successful.");
                } else {
                    System.out.println("Invalid amount.");
                }

            } else if (choice == 3) {  // Check Balance
                double balance = bankAccount.checkBalance();
                System.out.println("Your account balance is: " + balance);

            } else if (choice == 4) {  // Exit
                System.out.println("Thank you for using the ATM.");
                break;

            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(0);
        ATM atm = new ATM(account);

        atm.run();
    }
}