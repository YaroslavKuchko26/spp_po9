package Task_03;
import java.util.Random;

public class IdleState implements PrinterState {
    @Override
    public void printDocument(Printer printer) {
        System.out.println("Switching to Printing state...");
        printer.setCurrentState(new PrintingState());
        System.out.println(printer.getCurrentState().getStateDescription());
        printer.printDocument();
    }

    @Override
    public void removeJam(Printer printer) {
        System.out.println("No paper jam to remove.");
    }

    @Override
    public void loadPaper(Printer printer, int count) {
        printer.setPaperCount(printer.getPaperCount() + count);
        System.out.println("Loaded " + count + " sheets of paper.");
    }

    @Override
    public void refillInk(Printer printer) {
        printer.setInkLevel(100);
        System.out.println("Ink refilled to 100%.");
    }

    @Override
    public String getStateDescription() {
        return "IdleState";
    }
}
