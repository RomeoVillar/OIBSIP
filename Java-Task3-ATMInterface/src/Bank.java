import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Account> accounts = new HashMap<>();

    public Bank() {
        // Demo accounts for testing the application.
        accounts.put("1001", new Account("1001", "1234", "Romeo Villar", 5000.00));
        accounts.put("1002", new Account("1002", "4321", "Alex Santos", 3000.00));
    }

    public Account authenticate(String accountId, String pin) {
        Account account = accounts.get(accountId);
        if (account != null && account.getPin().equals(pin)) {
            return account;
        }
        return null;
    }

    public Account findAccount(String accountId) {
        return accounts.get(accountId);
    }

    public boolean transfer(Account sender, String recipientId, double amount) {
        Account recipient = accounts.get(recipientId);

        if (recipient == null || sender == null || sender == recipient
                || amount <= 0 || amount > sender.getBalance()) {
            return false;
        }

        sender.withdraw(amount);
        recipient.deposit(amount);

        sender.addTransaction(new Transaction(
                "TRANSFER SENT", amount,
                "Sent to account " + recipient.getAccountId()));
        recipient.addTransaction(new Transaction(
                "TRANSFER RECEIVED", amount,
                "Received from account " + sender.getAccountId()));
        return true;
    }
}
