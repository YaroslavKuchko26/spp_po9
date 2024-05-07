package Task_02;

public interface ActivityLevel {
    void purchaseBook(Book book, CustomerAccount customer);
    void checkUpgrade(CustomerAccount customer);
    void participateInContest(CustomerAccount customer);
}
