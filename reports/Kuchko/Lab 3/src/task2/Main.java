package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

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

        System.out.println("dictionary.search(\"собака\")");
        System.out.println(dictionary.search("собака")); // Пример запроса слова из словаря
    }
}

class Dictionary {
    private Map<String, Integer> wordCountMap;

    public Dictionary() {
        wordCountMap = new HashMap<>();
    }

    public String search(String word) {
        if (wordCountMap.containsKey(word)) {
            int count = wordCountMap.get(word);
            wordCountMap.put(word, count + 1);
            return "Word found!";
        } else {
            return "Word not found!";
        }
    }
}