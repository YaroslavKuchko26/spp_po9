package Task_02;

import java.util.Random;

public class PremiumLevelDecorator extends BasicLevelDecorator {
    @Override
    public void purchaseBook(Book book, CustomerAccount customer) {
        super.purchaseBook(book, customer);
    }

    @Override
    public void checkUpgrade(CustomerAccount customer) {
        if (customer.getPoints() >= 10) {
            customer.setActivityLevel(new EliteLevelDecorator());
            System.out.println("Congratulations! You have been upgraded to Elite Level.");
        }
    }
    public void participateInContest(CustomerAccount customer) {
        Random random = new Random();
        int result = random.nextInt(100);
        if (result < 30) {
            System.out.println("You won the contest");
            customer.addBalance(5);
        } else {
            System.out.println("Better luck next time! No prize this time.");
        }
    }
}

