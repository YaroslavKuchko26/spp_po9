package org.example;
import java.util.List;
import java.util.ArrayList;

interface Component {
    double getCost();
}

enum Transport implements Component {
    PLANE(100), TRAIN(50), BUS(20);

    private final double cost;

    Transport(double cost) {
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}

enum Accommodation implements Component {
    HOTEL(150), HOSTEL(30), APARTMENTS(70);

    private final double cost;

    Accommodation(double cost) {
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}

enum Meals implements Component {
    BREAKFAST(20), HALF_BOARD(40), FULL_BOARD(60);

    private final double cost;

    Meals(double cost) {
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}

enum Sightseeing implements Component {
    MUSEUM(10), EXHIBITION(5), EXCURSION(20);

    private final double cost;

    Sightseeing(double cost) {
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}

class TourBuilder {

    private Transport transport;
    private Accommodation accommodation;
    private Meals meals;
    private List<Sightseeing> sightseeing = new ArrayList<>();

    private double cost;

    public TourBuilder setTransport(Transport transport) {
        this.transport = transport;
        recalculateCost();
        return this;
    }

    public TourBuilder setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
        recalculateCost();
        return this;
    }

    public TourBuilder setMeals(Meals meals) {
        this.meals = meals;
        recalculateCost();
        return this;
    }

    public TourBuilder addSightseeing(Sightseeing sightseeing) {
        this.sightseeing.add(sightseeing);
        recalculateCost();
        return this;
    }

    private void recalculateCost() {
        cost = 0;
        if (transport != null) {
            cost += transport.getCost();
        }
        if (accommodation != null) {
            cost += accommodation.getCost();
        }
        if (meals != null) {
            cost += meals.getCost();
        }
        for (Sightseeing s : sightseeing) {
            cost += s.getCost();
        }
    }

    public Tour buildTour() {
        return new Tour(transport, accommodation, meals, sightseeing, cost);
    }
}
class Tour {

    private Transport transport;
    private Accommodation accommodation;
    private Meals meals;
    private List<Sightseeing> sightseeing;
    private double cost;

    public Tour(Transport transport, Accommodation accommodation, Meals meals, List<Sightseeing> sightseeing, double cost) {
        this.transport = transport;
        this.accommodation = accommodation;
        this.meals = meals;
        this.sightseeing = sightseeing;
        this.cost = cost;
    }

    public Transport getTransport() {
        return transport;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public Meals getMeals() {
        return meals;
    }

    public List<Sightseeing> getSightseeing() {
        return sightseeing;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "transport=" + transport +
                ", accommodation=" + accommodation +
                ", meals=" + meals +
                ", sightseeing=" + sightseeing +
                ", cost=" + cost +
                '}';
    }
}
interface TourDirector {

    TourBuilder createTour();
}
class SimpleTourDirector implements TourDirector {

    @Override
    public TourBuilder createTour() {
        return new TourBuilder();
    }}

class TourApp {

    public static void main(String[] args) {

        TourDirector director = new SimpleTourDirector();


        TourBuilder builder = director.createTour();

        builder.setTransport(Transport.PLANE);
        builder.setAccommodation(Accommodation.HOTEL);
        builder.setMeals(Meals.FULL_BOARD);
        builder.addSightseeing(Sightseeing.MUSEUM);
        builder.addSightseeing(Sightseeing.EXHIBITION);

        Tour tour = builder.buildTour();

        System.out.println("Стоимость тура: " + tour.getCost());
        System.out.println("Включено:");
        System.out.println("    - Проезд: " + tour.getTransport());
        System.out.println("    - Проживание: " + tour.getAccommodation());
        System.out.println("    - Питание: " + tour.getMeals());
        System.out.println("    - Достопримечательности:");
        for (Sightseeing sightseeing : tour.getSightseeing()) {
            System.out.println("        - " + sightseeing);
        }
    }
}