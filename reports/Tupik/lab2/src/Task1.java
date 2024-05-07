import java.io.*;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        randomiseWordOrder();
    }

    static void randomiseWordOrder(){
        String pathToFile = "src/file.txt";

        String[] wordsInText = readTextFromFile(pathToFile).split(" ");

        Random randomNum = new Random();
        for (int i = wordsInText.length - 1; i >= 0; i--) {
            int randomIndex = randomNum.nextInt(i + 1);
            String temp = wordsInText[randomIndex];
            wordsInText[randomIndex] = wordsInText[i];
            wordsInText[i] = temp;
        }

        StringBuilder randomisedText;
        randomisedText = new StringBuilder();
        for (String word : wordsInText) {
            randomisedText.append(word).append(" ");
        }

        System.out.print(randomisedText);
    }

    static String readTextFromFile (String pathToFile) {
        StringBuilder textFromFile = new StringBuilder();
        try (BufferedReader fileInput = new BufferedReader(new FileReader(pathToFile))) {
            String nextString;
            while ((nextString = fileInput.readLine()) != null) {
                textFromFile.append(nextString);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Reading was interrupted.");
        }
        return textFromFile.toString();
    }

}