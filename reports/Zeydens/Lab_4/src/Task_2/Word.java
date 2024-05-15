public class Word {
    String word;
    Word() { this.word = ""; }
    Word (String word) { this.word = word; }
    public String getWord() { return this.word; }
    public char getSymbol(int i) { return word.charAt(i); }
    public String getSubsequence(int i, int j) {
        if(i < 0 || i > this.word.length() || j < 0 || j > this.word.length()) { return ""; }
        if(i <= j) { return word.substring(i, j); }
        return word.substring(j, i);
    }
    public void setWord(String word) { this.word = word; }
    public void printWord() { System.out.print(this.word + '\n'); }
}
