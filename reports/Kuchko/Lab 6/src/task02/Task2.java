package org.example.task02;

public class Task2 {
    public static void main(String[] args) {
        DigitalCard card = new DigitalCard("12344321", "4567890711114332", "456789876453721234");

        System.out.println(card.getPassportInfo());
        System.out.println(card.getBankCardInfo());
        System.out.println(card.getInsuranceInfo());
    }
}