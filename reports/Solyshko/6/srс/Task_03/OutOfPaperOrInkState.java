package Task_03;

public class OutOfPaperOrInkState implements PrinterState {
    @Override
    public void printDocument(Printer printer) {
        System.out.println("Cannot print. Out of paper or ink.");
    }

    @Override
    public void removeJam(Printer printer) {
        System.out.println("No paper jam to remove.");
    }

    @Override
    public void loadPaper(Printer printer, int count) {
        printer.setPaperCount(printer.getPaperCount() + count);
        printer.setCurrentState(new IdleState());
        System.out.println("Paper and ink refilled. Printer ready.");
        System.out.println(printer.getCurrentState().getStateDescription());
    }

    @Override
    public void refillInk(Printer printer) {
        printer.setInkLevel(100);
        printer.setCurrentState(new IdleState());
        System.out.println("Paper and ink refilled. Printer ready.");
        System.out.println(printer.getCurrentState().getStateDescription());
    }

    @Override
    public String getStateDescription() {
        return "OutOfPaperOrInkState";
    }
}
