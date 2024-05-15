import java.util.ArrayList;
// Класс, представляющий тур
class Tour {
    private Transportation transportation;
    private Accommodation accommodation;
    private Meals meals;
    private ArrayList<Sightseeing> sightseeingList;
    public Tour() { sightseeingList = new ArrayList<>(); }
    public void setTransportation(Transportation transportation) { this.transportation = transportation; }
    public void setAccommodation(Accommodation accommodation) { this.accommodation = accommodation; }
    public void setMeals(Meals meals) { this.meals = meals; }
    public void addSightseeing(Sightseeing sightseeing) { sightseeingList.add(sightseeing); }
    public double getTotalCost() {
        double totalCost = 0;
        if (transportation != null) { totalCost += transportation.getCost(); }
        if (accommodation != null) { totalCost += accommodation.getCost(); }
        if (meals != null) { totalCost += meals.getCost(); }
        for (Sightseeing sightseeing : sightseeingList) { totalCost += sightseeing.getCost(); }
        return totalCost;
    }
}
// Класс, представляющий транспорт
class Transportation {
    private double cost;
    public Transportation(double cost) { this.cost = cost; }
    public double getCost() { return cost; }
}
// Класс, представляющий проживание
class Accommodation {
    private double cost;
    public Accommodation(double cost) { this.cost = cost; }
    public double getCost() { return cost; }
}
// Класс, представляющий питание
class Meals {
    private double cost;
    public Meals(double cost) { this.cost = cost; }
    public double getCost() { return cost; }
}
// Класс, представляющий экскурсию
class Sightseeing {
    private double cost;
    public Sightseeing(double cost) { this.cost = cost; }
    public double getCost() { return cost; }
}
// Класс, отвечающий за построение тура
class TourBuilder {
    private Tour tour;
    public TourBuilder() { tour = new Tour(); }
    public TourBuilder setTransportation(Transportation transportation) {
        tour.setTransportation(transportation);
        return this;
    }
    public TourBuilder setAccommodation(Accommodation accommodation) {
        tour.setAccommodation(accommodation);
        return this;
    }
    public TourBuilder setMeals(Meals meals) {
        tour.setMeals(meals);
        return this;
    }
    public TourBuilder addSightseeing(Sightseeing sightseeing) {
        tour.addSightseeing(sightseeing);
        return this;
    }
    public Tour build() { return tour; }
}

public class Main {
    public static void main(String[] args) {
        Tour tour = new TourBuilder()
                .setTransportation(new Transportation(100.0))
                .setAccommodation(new Accommodation(200.0))
                .setMeals(new Meals(50.0))
                .addSightseeing(new Sightseeing(30.0))
                .addSightseeing(new Sightseeing(40.0))
                .build();
        double totalCost = tour.getTotalCost();
        System.out.println("Total cost of the tour: $" + totalCost);
    }
}