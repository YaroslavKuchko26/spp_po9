package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task01 {
    public static void main(String[] args) {
        if (args.length < 1) throw new FileOnReadException("Нет аргумента файла.");

        List<String> lines = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new FileOnReadException(args[0]);
        }

        lines.sort(Comparator.comparing(String::length));

        for (String line : lines) {
            System.out.println(line);
        }
    }
}