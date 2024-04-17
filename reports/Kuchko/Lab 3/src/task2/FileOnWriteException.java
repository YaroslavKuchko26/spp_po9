package org.example;

public class FileOnWriteException extends RuntimeException {
    public FileOnWriteException(String message) {
        super("Unable to write file: " + message);
    }
}