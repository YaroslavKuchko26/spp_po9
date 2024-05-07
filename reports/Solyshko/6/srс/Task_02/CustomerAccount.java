package Task_02;

public class CustomerAccount {
    private ActivityLevel activityLevel;
    private int points;
    private double balance;

    public CustomerAccount() {
        this.activityLevel = new BasicLevelDecorator();
        this.points = 0;
        this.balance = 0;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public void incrementPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public double getBalance() {
        return balance;
    }

    public void purchaseBook(Book book) {
        if (book.getPrice() <= balance) {
            System.out.println("Purchasing book: " + book.getTitle() + " for $" +
                    book.getPrice());
            balance -= book.getPrice();
            System.out.println("Remaining balance: $" + balance);
            activityLevel.purchaseBook(book, this);
        } else {
            System.out.println("Not enough balance to purchase " + book.getTitle());
        }
    }

    public void participateInContest() {
        activityLevel.participateInContest(this);
    }

    public void addBalance(double amount) {
        balance += amount;
        System.out.println("Added $" + amount + " to your balance. Current balance: $" + balance);
    }
}
