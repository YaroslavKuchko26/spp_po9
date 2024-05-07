package Task_02;

public class BasicLevelDecorator implements ActivityLevel {
    @Override
    public void purchaseBook(Book book, CustomerAccount customer) {
        System.out.println("Purchasing book: " + book.getTitle());
        customer.incrementPoints(book.getPoints());
        checkUpgrade(customer);
    }

    @Override
    public void checkUpgrade(CustomerAccount customer) {
        if (customer.getPoints() >= 5) {
            customer.setActivityLevel(new PremiumLevelDecorator());
            System.out.println("Congratulations! You have been upgraded to Premium Level.");
        }
    }

    @Override
    public void participateInContest(CustomerAccount customer){
        System.out.println("Contest participation is not available for the current activity level.");
    }
}
