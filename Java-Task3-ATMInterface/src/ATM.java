import java.util.Scanner;

public class ATM {
    private final Bank bank;
    private final Scanner scanner;

    public ATM(Bank bank, Scanner scanner) {
        this.bank = bank;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("=================================");
        System.out.println("       JAVA ATM INTERFACE");
        System.out.println("=================================");

        Account account = login();
        if (account == null) {
            System.out.println("Access denied. Too many incorrect attempts.");
            return;
        }

        System.out.println("\nWelcome, " + account.getAccountHolder() + "!");
        runMenu(account);
    }

    private Account login() {
        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine().trim();

            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine().trim();

            Account account = bank.authenticate(userId, pin);
            if (account != null) {
                return account;
            }

            int remaining = 3 - attempt;
            if (remaining > 0) {
                System.out.println("Incorrect User ID or PIN. Attempts remaining: " + remaining + "\n");
            }
        }
        return null;
    }

    private void runMenu(Account account) {
        boolean running = true;

        while (running) {
            System.out.println("\n----------- MAIN MENU -----------");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    showTransactionHistory(account);
                    break;
                case "2":
                    withdraw(account);
                    break;
                case "3":
                    deposit(account);
                    break;
                case "4":
                    transfer(account);
                    break;
                case "5":
                    System.out.println("Thank you for using Java ATM Interface. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1 to 5.");
            }
        }
    }

    private void showTransactionHistory(Account account) {
        System.out.println("\n------- TRANSACTION HISTORY -------");
        if (account.getTransactions().isEmpty()) {
            System.out.println("No transactions recorded in this session.");
        } else {
            for (int i = 0; i < account.getTransactions().size(); i++) {
                System.out.println((i + 1) + ". " + account.getTransactions().get(i));
            }
        }
        System.out.printf("Current Balance: ₱%.2f%n", account.getBalance());
    }

    private void withdraw(Account account) {
        double amount = readAmount("Enter amount to withdraw: ");
        if (amount <= 0) {
            System.out.println("Invalid amount. Enter an amount greater than zero.");
            return;
        }

        if (!account.withdraw(amount)) {
            System.out.println("Insufficient Funds.");
            return;
        }

        account.addTransaction(new Transaction("WITHDRAWAL", amount, "Cash withdrawal"));
        System.out.printf("Withdrawal successful. New balance: ₱%.2f%n", account.getBalance());
    }

    private void deposit(Account account) {
        double amount = readAmount("Enter amount to deposit: ");
        if (amount <= 0) {
            System.out.println("Invalid amount. Enter an amount greater than zero.");
            return;
        }

        account.deposit(amount);
        account.addTransaction(new Transaction("DEPOSIT", amount, "Cash deposit"));
        System.out.printf("Deposit successful. New balance: ₱%.2f%n", account.getBalance());
    }

    private void transfer(Account account) {
        System.out.print("Enter recipient account ID: ");
        String recipientId = scanner.nextLine().trim();

        if (bank.findAccount(recipientId) == null) {
            System.out.println("Recipient account not found.");
            return;
        }
        if (recipientId.equals(account.getAccountId())) {
            System.out.println("You cannot transfer money to your own account.");
            return;
        }

        double amount = readAmount("Enter amount to transfer: ");
        if (amount <= 0) {
            System.out.println("Invalid amount. Enter an amount greater than zero.");
            return;
        }

        if (amount > account.getBalance()) {
            System.out.println("Insufficient Funds.");
            return;
        }

        if (bank.transfer(account, recipientId, amount)) {
            System.out.printf("Transfer successful. New balance: ₱%.2f%n", account.getBalance());
        } else {
            System.out.println("Transfer failed. Please check the details and try again.");
        }
    }

    private double readAmount(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException exception) {
            return -1;
        }
    }
}
