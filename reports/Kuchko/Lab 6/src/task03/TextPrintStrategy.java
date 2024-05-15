package org.example.task03;

public class TextPrintStrategy implements PrinterStrategy {
    @Override
    public PrintResult print(String message) {
        System.out.println("Printing text: " + message);
        TextPrintResult text = new TextPrintResult(message);
        return text;
    }
}
