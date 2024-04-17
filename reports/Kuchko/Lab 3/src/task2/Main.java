package org.example;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.readFile(args[0]);

        System.out.println("dictionary by alphabet");
        System.out.println(dictionary.getItemsByAlphabet());
        System.out.println();
        System.out.println("dictionary by requests amount");
        System.out.println(dictionary.getItemsByRequests());
        System.out.println();

        System.out.println("dictionary.add()");
        dictionary.add(new DictionaryItem("собака", "dog", 67));

        System.out.println("dictionary by alphabet");
        System.out.println(dictionary.getItemsByAlphabet());
        System.out.println();
        System.out.println("dictionary by requests amount");
        System.out.println(dictionary.getItemsByRequests());
        System.out.println();

        System.out.println("dictionary.remove()");
        dictionary.remove(dictionary.search("кот"));

        System.out.println("dictionary by alphabet");
        System.out.println(dictionary.getItemsByAlphabet());
        System.out.println();
        System.out.println("dictionary by requests amount");
        System.out.println(dictionary.getItemsByRequests());
        System.out.println();

        System.out.println("dictionary.search(\"alphabet\")");
        System.out.println(dictionary.search("alphabet"));
    }
}