package org.example.task03;

public class PhotoPrintStrategy implements PrinterStrategy {
    @Override
    public PrintResult print(String message) {
        System.out.println("Printing photo with URI " + message);
        PhotoPrintResult photo = new PhotoPrintResult(message);
        return photo;
    }
}
