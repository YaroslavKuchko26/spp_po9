package Task_03;

public class PaperJamState implements PrinterState {
    @Override
    public void printDocument(Printer printer) {
        System.out.println("Cannot print. Paper jammed.");
    }

    @Override
    public void removeJam(Printer printer) {
        System.out.println("Removing paper jam...");
        printer.setCurrentState(new IdleState());
        System.out.println(printer.getCurrentState().getStateDescription());
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
        return "PaperJamState";
    }
}
