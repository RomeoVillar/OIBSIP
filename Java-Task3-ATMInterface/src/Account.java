import java.util.ArrayList;

public class Account {
    private final String accountId;
    private final String pin;
    private String accountHolder;
    private double balance;
    private final ArrayList<Transaction> transactions;

    public Account(String accountId, String pin, String accountHolder, double openingBalance) {
        this.accountId = accountId;
        this.pin = pin;
        this.accountHolder = accountHolder;
        this.balance = openingBalance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPin() {
        return pin;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder.trim();
        }
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
