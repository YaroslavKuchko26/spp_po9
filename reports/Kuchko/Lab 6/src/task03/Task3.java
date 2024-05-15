package org.example.task03;

public class Task3 {
    public static void main(String[] args) {
        PrinterContext context = new PrinterContext();

        context.setStrategy(new TextPrintStrategy());
        System.out.println(context.executePrint("Text text text text"));


        context.setStrategy(new PhotoPrintStrategy());
        System.out.println(context.executePrint("./photo.png"));
    }
}