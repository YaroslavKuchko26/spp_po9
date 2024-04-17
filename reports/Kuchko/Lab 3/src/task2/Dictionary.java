package org.example;

import java.io.*;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Dictionary {

    private static final Comparator<DictionaryItem> alphabetComparator = new Comparator<DictionaryItem>() {
        @Override
        public int compare(DictionaryItem o1, DictionaryItem o2) {
            return o1.getValueRu().compareTo(o2.getValueRu());
        }
    };

    private static final Comparator<DictionaryItem> resuestsComparator = new Comparator<DictionaryItem>() {
        @Override
        public int compare(DictionaryItem o1, DictionaryItem o2) {
            return o1.getRequestsAmount().compareTo(o2.getRequestsAmount());
        }
    };

    private final SortedSet<DictionaryItem> itemsByAlphabet;
    private final SortedSet<DictionaryItem> itemsByRequests;

    public Dictionary() {
        itemsByAlphabet = new TreeSet<>(alphabetComparator);
        itemsByRequests = new TreeSet<>(resuestsComparator);
    }

    public boolean add(DictionaryItem item) {
        return itemsByAlphabet.add(item) && itemsByRequests.add(item);
    }

    public boolean remove(DictionaryItem item) {
        return itemsByAlphabet.remove(item) && itemsByRequests.remove(item);
    }

    public DictionaryItem search(String value) {
        DictionaryItem result =  itemsByAlphabet.stream().filter(item -> item.getValueRu().equalsIgnoreCase(value)).findFirst()
                .orElse(itemsByAlphabet.stream().filter(item -> item.getValueEn().equalsIgnoreCase(value)).findFirst().orElse(null));
        result.setRequestsAmount(item.getRequestsAmount() + 1);
        return result;
    }

    public void readFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] words = line.split("\\s+");
                DictionaryItem item = new DictionaryItem(words[0], words[1], Integer.valueOf(words[2]));
                itemsByAlphabet.add(item);
                itemsByRequests.add(item);
            }
        } catch (IOException | IndexOutOfBoundsException e) {
            throw new FileOnReadException(fileName);
        }
    }

    public void writeFile(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            itemsByAlphabet.forEach(item -> {
                try {
                    writer.write(item.getValueRu() + " " + item.getValueEn() + " " + item.getRequestsAmount());
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            writer.close();
        } catch (IOException e) {
            throw new FileOnWriteException(fileName);
        }
    }

    public SortedSet<DictionaryItem> getItemsByAlphabet() {
        return itemsByAlphabet;
    }

    public SortedSet<DictionaryItem> getItemsByRequests() {
        return itemsByRequests;
    }
}
