import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

// Class to represent the ATM machine
public class ATM_Machine {

    private BankAccount account;
    private Scanner scanner;

    public ATM_Machine(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    // Display ATM menu
    public void start() {
        System.out.println("🏦 Welcome to Simple ATM");

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. 💸 Withdraw");
            System.out.println("2. 💰 Deposit");
            System.out.println("3. 📄 Check Balance");
            System.out.println("4. 🚪 Exit");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println("✅ Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }

    // Handle withdrawal
    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("✅ Withdrawal successful. ₹" + amount + " has been debited.");
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }

    // Handle deposit
    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();

        if (account.deposit(amount)) {
            System.out.println("✅ Deposit successful. ₹" + amount + " has been added.");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Handle balance check
    private void handleCheckBalance() {
        System.out.printf("💼 Your current balance is: ₹%.2f\n", account.getBalance());
    }

    // Main method to run the ATM
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);  // Initial balance ₹1000
        ATM_Machine atm = new ATM_Machine(userAccount);
        atm.start();
    }
}




