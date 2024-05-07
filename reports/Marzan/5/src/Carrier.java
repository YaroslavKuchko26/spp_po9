abstract class Carrier {
    private String name;

    public Carrier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTime(int distance);

    public abstract double calculateCost(int distance);
}
