package org.example;

public class FileOnReadException extends RuntimeException {
    public FileOnReadException(String message) {
        super("Невозможно прочитать файл: " + message);
    }
}
