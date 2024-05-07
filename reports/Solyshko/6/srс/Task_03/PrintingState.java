package Task_03;
import java.util.Random;
public class PrintingState implements PrinterState {
    @Override
    public void printDocument(Printer printer) {
        int jamProbability = new Random().nextInt(100) + 1;
        if (jamProbability <= printer.getJamProbability()) {
            System.out.println("Paper jammed!");
            printer.setCurrentState(new PaperJamState());
            System.out.println(printer.getCurrentState().getStateDescription());
        } else if (printer.getPaperCount() <= 0 || printer.getInkLevel() <= 0) {
            System.out.println("Out of paper or ink. Printing stopped.");
            printer.setCurrentState(new OutOfPaperOrInkState());
            System.out.println(printer.getCurrentState().getStateDescription());
        }
        else {
            System.out.println("Already printing...");
            printer.setPaperCount(printer.getPaperCount() - 1);
            printer.setInkLevel(printer.getInkLevel() - 10);
            printer.setCurrentState(new IdleState());
            System.out.println(printer.getCurrentState().getStateDescription());
        }
    }

    @Override
    public void removeJam(Printer printer) {
        System.out.println("Cannot remove paper jam while printing.");
    }

    @Override
    public void loadPaper(Printer printer, int count) {
        System.out.println("Cannot load paper while printing.");
    }

    @Override
    public void refillInk(Printer printer) {
        System.out.println("Cannot refill ink while printing.");
    }

    @Override
    public String getStateDescription() {
        return "PrintingState";
    }
}
