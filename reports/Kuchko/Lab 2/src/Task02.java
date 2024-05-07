package org.example;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) throws URISyntaxException {
        List<String> result = new ArrayList<>();
        String localPath = new File(Task02.class.getProtectionDomain().getCodeSource().getLocation()
                .toURI()).getParentFile().getPath();
        Scanner consoleInput = new Scanner(System.in);

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "-" -> { // ввод из консоли
                    readConsole(result, consoleInput);
                }
                case ">" -> { // вывод в файл
                    writeFile(localPath + args[i+1], result);
                    return;
                }
                default -> { // ввод из файла
                    readFile(localPath + arg, result);
                }
            }
        }
        // вывод в консоль
        result.forEach(System.out::println);
    }

    private static void readFile(String fileName, List<String> result) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                result.add(line);
            }
        } catch (IOException e) {
            throw new FileOnReadException(fileName);
        }
    }

    private static void writeFile(String fileName, List<String> result) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            result.forEach(str -> {
                try {
                    writer.write(str);
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
    private static void readConsole(List<String> result, Scanner scanner) {
        result.add(scanner.nextLine());
    }

}