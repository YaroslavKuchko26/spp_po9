package org.example;

public class FileOnReadException extends RuntimeException {
    public FileOnReadException(String message) {
        super("Unable to read file: " + message);
    }
}