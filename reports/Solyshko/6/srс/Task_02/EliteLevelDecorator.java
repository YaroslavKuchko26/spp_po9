package Task_02;

import java.util.Random;

public class EliteLevelDecorator extends PremiumLevelDecorator {
    @Override
    public void purchaseBook(Book book, CustomerAccount customer) {
        System.out.println("Purchasing book: " + book.getTitle());
        customer.incrementPoints(book.getPoints());
        double discount = book.getPrice() * 0.1; // 10% скидка для элиты
        customer.addBalance(discount);
        System.out.println("You received a cashback of $" + discount + " for your elite level.");
    }

    @Override
    public void participateInContest(CustomerAccount customer) {
        Random random = new Random();
        int result = random.nextInt(100);
        if (result < 30) {
            System.out.println("You won the contest");
            customer.addBalance(10);
        } else {
            System.out.println("Better luck next time! No prize this time.");
        }
    }
}
