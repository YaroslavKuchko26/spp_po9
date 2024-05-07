package org.example;

public class Task03 {
    public static void main(String[] args) {
        System.out.println(stripWhitespaces(null));
        System.out.println(stripWhitespaces(""));
        System.out.println(stripWhitespaces(" "));
        System.out.println(stripWhitespaces(" abc "));
        System.out.println(stripWhitespaces(" abc "));
        System.out.println(stripWhitespaces(" abc "));
        System.out.println(stripWhitespaces(" abc "));
        System.out.println(stripWhitespaces(" ab c "));
    }

    private static String stripWhitespaces(String str) {
        if (str == null) return null;
        return str.trim();
    }
}
