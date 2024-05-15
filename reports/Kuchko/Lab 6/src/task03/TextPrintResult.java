package org.example.task03;

public class TextPrintResult extends PrintResult {
    protected String text;

    public TextPrintResult(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextPrintResult{" +
                "text='" + text + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
