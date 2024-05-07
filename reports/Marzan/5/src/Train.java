class Train extends Carrier implements Identifiable {
    private String identifier;
    private double speed;
    private double costPerKm;

    public Train(String name, String identifier, double speed, double costPerKm) {
        super(name);
        this.identifier = identifier;
        this.speed = speed;
        this.costPerKm = costPerKm;
    }

    public String getIdentifier() {
        return identifier;
    }

    public double calculateTime(int distance) {
        return distance / speed;
    }

    public double calculateCost(int distance) {
        return distance * costPerKm;
    }
}