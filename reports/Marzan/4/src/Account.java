import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private String accountId;
    private List<Transaction> transactions;

    public Account(String accountNumber) {
        this.accountId = accountNumber;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        Transaction transaction = new Transaction("deposit", amount);
        transactions.add(transaction);
    }

    public void withdrawal(double amount) {
        Transaction transaction = new Transaction("withdrawal", amount);
        transactions.add(transaction);
    }

    public void payment(double amount) {
        Transaction transaction = new Transaction("payment", amount);
        transactions.add(transaction);
    }

    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private class Transaction {
        private String type;
        private double amount;
        private Date date;

        public Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
            this.date = new Date();
        }

        @Override
        public String toString() {
            return "Type: " + type + ", Amount: " + amount + ", Date: " + date;
        }
    }
}