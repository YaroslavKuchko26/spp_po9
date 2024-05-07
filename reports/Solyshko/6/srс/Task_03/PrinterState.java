package Task_03;

public interface PrinterState {
    void printDocument(Printer printer);
    void removeJam(Printer printer);
    void loadPaper(Printer printer, int count);
    void refillInk(Printer printer);
    String getStateDescription();
}
