import java.util.ArrayList;
import java.util.List;

public class Lab5_3 {

    public class Trip {

        private String destination;
        private Car car;
        private Driver driver;
        private boolean isEnd;

        public Trip(String destination, Car car, Driver driver) {
            this.destination = destination;
            this.car = car;
            this.driver = driver;
            this.isEnd = false;
        }
        public boolean getStatus() {
            return isEnd;
        }

        public void setStatus(boolean isEnd) {
            this.isEnd = isEnd;
        }
        public String getDestination() {
            return destination;
        }


        public Car getCar() {
            return car;
        }

        public Driver getDriver() {
            return driver;
        }

        @Override
        public String toString() {
            return "Рейс: " + destination + " (" + car + ", " + driver + ")";
        }

        public void setCar(Car car) {
            this.car = car;
        }

        public void setDriver(Driver driver) {
            this.driver = driver;
        }
    }
    public class Driver {

        private String name;
        private boolean available;

        private Trip trip;
        public Driver(String name) {
            this.name = name;
            this.available = true;
        }
        public void sendCarToRepair(){
            if (trip !=null){
                trip.getCar().setAvailable(false);
            }
        }

        public void setTrip(Trip trip){
            this.trip=trip;
        }
        public void markTripCompleted() {
            if (trip !=null){
                trip.setStatus(true);
                this.available=true;
                trip.getCar().setAvailable(true);
                return;
            }
            System.out.println("У водителя нет рейса");
        }
        public String getName() {
            return name;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        @Override
        public String toString() {
            return "Водитель: " + name;
        }
    }

    public class Car {

        private String model;
        private String licensePlate;
        private boolean available;

        public Car(String model, String licensePlate) {
            this.model = model;
            this.licensePlate = licensePlate;
            this.available = true;
        }

        public String getModel() {
            return model;
        }

        public String getLicensePlate() {
            return licensePlate;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        @Override
        public String toString() {
            return "Автомобиль: " + model + " (" + licensePlate + ")";
        }
    }
    public class Dispatcher {

        private List<Car> cars;
        private List<Driver> drivers;
        private List<Trip> trips;

        public Dispatcher() {
            this.cars = new ArrayList<>();
            this.drivers = new ArrayList<>();
            this.trips = new ArrayList<>();
        }

        public void addCar(Car car) {
            cars.add(car);
        }

        public void addDriver(Driver driver) {
            drivers.add(driver);
        }

        public Trip assignTrip(String destination) {
            Car car = findAvailableCar();
            Driver driver = findAvailableDriver();
            Trip trip= new Trip(destination, car, driver);
            driver.setTrip(trip);
            trip.setCar(car);
            trip.setDriver(driver);
            car.setAvailable(false);
            driver.setAvailable(false);
            trips.add(trip);
            System.out.println("На рейс назначен: " + driver.toString() + " " + car.toString());
            return trip;
        }

        private Car findAvailableCar() {
            for (Car car : cars) {
                if (car.isAvailable()) {
                    return car;
                }
            }
            return null;
        }

        private Driver findAvailableDriver() {
            for (Driver driver : drivers) {
                if (driver.isAvailable()) {
                    return driver;
                }
            }
            return null;
        }

        public void removeDriver(Driver driver) {
            drivers.remove(driver);
        }



        public List<Car> getAvailableCars() {
            List<Car> result = new ArrayList<Car>();
            for (Car car : cars){
                if (car.isAvailable())
                    result.add(car);
            }
            return result;
        }

        public List<Driver> getAvailableDrivers() {
            List<Driver> result = new ArrayList<Driver>();
            for (Driver driver : drivers){
                if (driver.isAvailable())
                    result.add(driver);
            }
            return result;
        }
    }

    public void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        Car car1 = new Car("Lada Granta", "A1234");
        Car car2 = new Car("Toyota Camry", "B5678");
        dispatcher.addCar(car1);
        dispatcher.addCar(car2);

        Driver driver1 = new Driver("Иван");
        Driver driver2 = new Driver("Петр");
        dispatcher.addDriver(driver1);
        dispatcher.addDriver(driver2);

        Trip trip= dispatcher.assignTrip("Владивосток");
        System.out.println(trip);
        dispatcher.removeDriver(driver2);
        driver1.markTripCompleted();
        for (Car car : dispatcher.getAvailableCars()) {
            System.out.println(car);
        }
        for (Driver driver : dispatcher.getAvailableDrivers()) {
            System.out.println(driver);
        }
    }



}
