import java.util.ArrayList;

public class Paragraph {
    ArrayList<Word> words;
    Paragraph() {
        this.words = new ArrayList<Word>();
        this.words.add(new Word(""));
    }
    Paragraph(ArrayList<Word> words) { this.words = words; }
    public ArrayList<Word> getWords() { return this.words; }
    public void setWords(ArrayList<Word> words) { this.words = words; }
    public void changeWord(String wordToChange, Word newWord) {
        for(int i = 1; i < this.words.size(); ++i) {
            if (this.words.get(i).getWord().equals(wordToChange)) {
               this.words.set(i, newWord);
               return;
            }
        }
        System.out.print("Word wasn't found\n");
    }
    public void addWord(Word word) { this.words.add(word); }
    public void setRedLineSize(int size) {
        String redLine = "";
        for(int i = 0; i < size; ++i) {
            redLine += " ";
        }
        this.words.set(0, new Word(redLine));
    }
    public void printParagraph() {
        System.out.print(this.words.get(0).getWord() + " ");
        for(int i = 1; i < this.words.size(); ++i) {
            if(i % 10 == 0) { System.out.print("\n"); }
            System.out.print(this.words.get(i).getWord() + " ");

        }
        System.out.print("\n");
    }
}
