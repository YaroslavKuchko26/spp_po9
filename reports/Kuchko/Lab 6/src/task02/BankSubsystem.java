package org.example.task02;

public class BankSubsystem {

    public static String getInfo(String cardNumber) {
        double balance = 100;
        // ... (поиск информации)
        return "На балансе карты №" + cardNumber + " " + balance;
    }

}
