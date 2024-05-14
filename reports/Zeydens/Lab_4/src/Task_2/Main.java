import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Paragraph myParagraph = new Paragraph();
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Choose option:\n" +
                    "\t1. Add word to paragraph\n" +
                    "\t2. Change red line of paragraph\n" +
                    "\t3. Print paragraph\n" +
                    "\t4. Get symbol from a word\n" +
                    "\t5. Get subsequence from a word\n" +
                    "\t6. Change word of a paragraph\n" +
                    "\t... exit\n");
            int elem = Integer.parseInt(in.next());
            switch (elem) {
                case 1: {
                    System.out.print("Enter a word: ");
                    String temp = in.next();
                    myParagraph.addWord(new Word(temp));
                    break;
                }
                case 2: {
                    System.out.print("Enter number of spaces: ");
                    int temp = Integer.parseInt(in.next());
                    myParagraph.setRedLineSize(temp);
                    break;
                }
                case 3: {
                    myParagraph.printParagraph();
                    break;
                }
                case 4: {
                    System.out.print("Enter word to get symbol from: ");
                    Word word = new Word(in.next());
                    System.out.print("Enter a number: ");
                    int symbolNumber = Integer.parseInt(in.next());
                    System.out.print(word.getSymbol(symbolNumber - 1) + "\n");
                    break;
                }
                case 5: {
                    System.out.print("Enter word to get subsequence from: ");
                    String line = in.next();
                    Word word = new Word(line);
                    System.out.print("Enter the first bound: ");
                    int startSymbol = Integer.parseInt(in.next());
                    System.out.print("Enter the second bound: ");
                    int endSymbol = Integer.parseInt(in.next());
                    System.out.print(word.getSubsequence(startSymbol - 1, endSymbol - 1) + "\n");
                    break;
                }
                case 6: {
                    System.out.print("Enter word to change in paragraph: ");
                    String wordToChange = in.next();
                    System.out.print("Enter new word: ");
                    Word newWord = new Word(in.next());
                    myParagraph.changeWord(wordToChange, newWord);
                    break;
                }
                default: {
                    return;
                }
            }
        }
    }
}