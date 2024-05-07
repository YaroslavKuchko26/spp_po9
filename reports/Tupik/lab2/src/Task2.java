
import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        int argsCount = args.length;
        if (argsCount < 1 || argsCount > 5) {
            System.out.println("Incorrect format. " +
                    "Try: paste [-s][-d] [file1 [file2]..]");
            return;
        }

        boolean swap = false;
        List<Character> delimiter = new ArrayList<>();
        delimiter.add('\t');
        List<List<String>> textFromFiles = new ArrayList<>();

        for (int i = 0; i < argsCount; i++) {
            switch (args[i]) {
                case "-s":
                    swap = true;
                    break;
                case "-d":
                    if (!args[i + 1].contains(".txt")) {
                        delimiter = divideStringToDelimiters(args[i + 1]);
                        i++;
                    } else {
                        System.out.println("The delimiters " +
                                "were not provided!");
                        return;
                    }
                    break;
                default:
                    textFromFiles.add(readTextFromFile(args[i]));
            }
        }

        int i = 0;
        int delimiterCount = delimiter.size();

        if (textFromFiles.size() == 1) {
            for (String line : textFromFiles.get(0)) {
                if (swap) {
                    System.out.print(line +
                            delimiter.get(i % delimiterCount));
                } else {
                    System.out.println(line +
                            delimiter.get(i % delimiterCount));
                }
                i++;
            }
        } else {
            Iterator<String> iteratorFile1 = textFromFiles.get(0).iterator();
            Iterator<String> iteratorFile2 = textFromFiles.get(1).iterator();

            if (swap) {
                while (iteratorFile1.hasNext()) {
                    System.out.print(iteratorFile1.next() +
                            delimiter.get(i % delimiterCount));
                    i++;
                }
                System.out.println();
                while (iteratorFile2.hasNext()) {
                    System.out.print(iteratorFile2.next() +
                            delimiter.get(i % delimiterCount));
                    i++;
                }
            } else {
                while (iteratorFile1.hasNext() && iteratorFile2.hasNext()) {
                    System.out.println(iteratorFile1.next()
                            + delimiter.get(i % delimiterCount)
                            + iteratorFile2.next());
                    i++;
                }
            }
        }
    }

    static ArrayList<String> readTextFromFile (String pathToFile) {
        ArrayList<String> textFromFile = new ArrayList<>();
        try (BufferedReader fileInput = new BufferedReader(new FileReader(pathToFile))) {
            String nextString;
            while ((nextString = fileInput.readLine()) != null) {
                textFromFile.add(nextString);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Reading was interrupted.");
        }
        return textFromFile;
    }

    static List<Character> divideStringToDelimiters (String delimitersFromArg) {
        List<Character> arrayOfDelimiters = new ArrayList<>();
        for (int i = 0; i < delimitersFromArg.length(); i++) {
            char ch = delimitersFromArg.charAt(i);
            if (ch == '\\') {
                switch (delimitersFromArg.charAt(i + 1)) {
                    case 'n':
                        arrayOfDelimiters.add('\n');
                        break;
                    case 't':
                        arrayOfDelimiters.add('\t');
                        break;
                }
                i++;
            } else {
                arrayOfDelimiters.add(ch);
            }
        }
        return arrayOfDelimiters;
    }
}
