package org.example.task03;

public class PrinterContext {
    private PrinterStrategy strategy;

    public void setStrategy(PrinterStrategy strategy) {
        this.strategy = strategy;
    }

    public PrintResult executePrint(String message) {
        return strategy.print(message);
    }

}
