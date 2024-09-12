import java.util.*;

public class BankingSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        boolean quit = false;

        System.out.println("Welcome to the Banking System!");
        while (!quit) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    showTransactionHistory();
                    break;
                case 6:
                    quit = true;
                    System.out.println("Thank you for using the Banking System!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account holder name: ");
        scanner.nextLine(); // consume the newline
        String name = scanner.nextLine();
        System.out.print("Enter a new account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists with this number!");
        } else {
            BankAccount account = new BankAccount(name, accountNumber);
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully for " + name);
        }
    }

    private static void deposit() {
        BankAccount account = getAccount();
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }
    }

    private static void withdraw() {
        BankAccount account = getAccount();
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }
    }

    private static void checkBalance() {
        BankAccount account = getAccount();
        if (account != null) {
            System.out.println("Account Balance: $" + account.getBalance());
        }
    }

    private static void showTransactionHistory() {
        BankAccount account = getAccount();
        if (account != null) {
            account.showTransactionHistory();
        }
    }

    private static BankAccount getAccount() {
        System.out.print("Enter account number: ");
        scanner.nextLine(); // consume the newline
        String accountNumber = scanner.nextLine();

        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("No account found with this number!");
        }
        return account;
    }
}
