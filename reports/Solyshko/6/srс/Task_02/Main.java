package Task_02;

public class Main {
    public static void main(String[] args) {
        CustomerAccount customer1 = new CustomerAccount();
        Book book1 = new Book("Book 1", 2, 10.0);
        Book book2 = new Book("Book 2", 3, 15.0);
        Book book3 = new Book("Book 3", 4, 20.0);
        Book book4 = new Book("Book 4", 2, 30.0);
        customer1.addBalance(100.0);

        customer1.purchaseBook(book1);
        customer1.purchaseBook(book2);
        customer1.purchaseBook(book3);

        System.out.println("Customer points: " + customer1.getPoints());
        System.out.println("Customer balance: $" + customer1.getBalance());

        customer1.addBalance(50.0);

        customer1.participateInContest();

        customer1.purchaseBook(book2);

        customer1.purchaseBook(book4);


        customer1.participateInContest();
    }
}