package org.example;

public class FileOnWriteException extends RuntimeException {
    public FileOnWriteException(String message) {
        super("Невозможно записать файл: " + message);
    }
}
