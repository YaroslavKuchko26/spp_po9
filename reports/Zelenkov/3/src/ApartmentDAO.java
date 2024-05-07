import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDAO {
    private List<Apartment> availableApartments;
    private List<Apartment> occupiedApartments;

    public ApartmentDAO() {
        this.availableApartments = new ArrayList<>();
        this.occupiedApartments = new ArrayList<>();
    }

    public void addApartment(Apartment apartment) {
        availableApartments.add(apartment);
    }

    public List<Apartment> getAvailableApartments() {
        return availableApartments;
    }

    public void displayAllApartments() {
        displayAvailableApartments();
        displayOccupiedApartments();
    }

    public void displayAvailableApartments() {
        System.out.println("Доступные апартаменты:");
        for (Apartment apartment : availableApartments) {
            System.out.println(apartment);
        }
    }

    public void displayOccupiedApartments() {
        System.out.println("Занятые квартиры:");
        for (Apartment apartment : occupiedApartments) {
            System.out.println(apartment);
        }
    }

    public void findMatchingApartment(int numberOfRooms, int floor, double minArea) {
        for (Apartment apartment : availableApartments) {
            if (apartment.isOccupied()) {
                continue;
            }

            if (apartment.getNumberOfRooms() == numberOfRooms &&
                    apartment.getFloor() == floor &&
                    Math.abs(apartment.getTotalArea() - minArea) <= 10) {
                System.out.println("Найдена подходящая квартира: " + apartment);
                return;
            }
        }

        System.out.println("Подходящая квартира не найдена.");
    }

    public void rentApartment(Apartment apartment) {
        if (availableApartments.contains(apartment)) {
            availableApartments.remove(apartment);
            apartment.setOccupied(true);
            occupiedApartments.add(apartment);
            System.out.println("Квартира успешно сдана в аренду: " + apartment);
        } else {
            System.out.println("Квартира не сдается в аренду.");
        }
    }

    public List<Apartment> getApartmentsByNumberOfRooms(int numberOfRooms) {
        List<Apartment> result = new ArrayList<>();
        for (Apartment apartment : availableApartments) {
            if (apartment.getNumberOfRooms() == numberOfRooms) {
                result.add(apartment);
            }
        }
        return result;
    }

    public List<Apartment> getApartmentsByRoomsAndFloor(int numberOfRooms, int floorRangeStart, int floorRangeEnd) {
        List<Apartment> result = new ArrayList<>();
        for (Apartment apartment : availableApartments) {
            if (apartment.getNumberOfRooms() == numberOfRooms &&
                    apartment.getFloor() >= floorRangeStart &&
                    apartment.getFloor() <= floorRangeEnd) {
                result.add(apartment);
            }
        }
        return result;
    }

    public List<Apartment> getApartmentsByArea(double minArea) {
        List<Apartment> result = new ArrayList<>();
        for (Apartment apartment : availableApartments) {
            if (apartment.getTotalArea() > minArea) {
                result.add(apartment);
            }
        }
        return result;
    }

    public static void loadFromFile(String fileName, ApartmentDAO system) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    int numberOfRooms = Integer.parseInt(parts[0]);
                    double totalArea = Double.parseDouble(parts[1]);
                    int floor = Integer.parseInt(parts[2]);
                    String address = parts[3];
                    double rentPrice = Double.parseDouble(parts[4]);

                    Apartment apartment = new Apartment(numberOfRooms, totalArea, floor, address, rentPrice);
                    system.addApartment(apartment);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}