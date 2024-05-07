package Task_03;

public class Printer {
    private String model;
    private int paperCount;
    private int inkLevel;
    private int jamProbability;
    private PrinterState currentState;

    public Printer(String model, int paperCount, int inkLevel, int jamProbability) {
        this.model = model;
        this.paperCount = paperCount;
        this.inkLevel = inkLevel;
        this.jamProbability = jamProbability;
        this.currentState = new IdleState();
    }

    public void printDocument() {
        currentState.printDocument(this);
    }

    public void loadPaper(int count) {
        currentState.loadPaper(this, count);
    }

    public void refillInk() {
        currentState.refillInk(this);
    }

    public void removeJam() {
        currentState.removeJam(this);
    }

    public String getModel() {
        return model;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }

    public int getInkLevel() {
        return inkLevel;
    }

    public void setInkLevel(int inkLevel) {
        this.inkLevel = inkLevel;
    }

    public int getJamProbability() {
        return jamProbability;
    }

    public void setCurrentState(PrinterState currentState) {
        this.currentState = currentState;
    }

    public PrinterState getCurrentState() {
        return currentState;
    }

    public void printStatus() {
        System.out.println("Printer Model: " + model);
        System.out.println("Paper Count: " + paperCount);
        System.out.println("Ink Level: " + inkLevel + "%");
        System.out.println("Current State: " + currentState.getStateDescription());
    }
}
