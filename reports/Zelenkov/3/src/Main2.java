import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        ApartmentDAO system = new ApartmentDAO();

        String path = "C:\\Users\\kosty\\IdeaProjects\\lab3\\src\\apart.txt";

        // Загрузка данных из файла
        ApartmentDAO.loadFromFile(path, system);

        // Отображение всех квартир
        system.displayAllApartments();

        // Аренда квартиры
        List<Apartment> availableApartments = system.getAvailableApartments();
        if (!availableApartments.isEmpty()) {
            Apartment apartmentToRent = availableApartments.get(0);
            system.rentApartment(apartmentToRent);
        } else {
            System.out.println("Свободных квартир для сдачи в аренду нет.");
        }

        // Отображение всех квартир после аренды
        system.displayAllApartments();

        // Поиск подходящей квартиры
        system.findMatchingApartment(2, 3, 80.0);

        system.findMatchingApartment(2, 4, 85.0);

        // Список квартир с заданным числом комнат
        List<Apartment> apartmentsByNumberOfRooms = system.getApartmentsByNumberOfRooms(2);
        System.out.println("Апартаменты с 2 комнатами: " + apartmentsByNumberOfRooms);

        // Список квартир с заданным числом комнат и этажем в заданном промежутке
        List<Apartment> apartmentsByRoomsAndFloor = system.getApartmentsByRoomsAndFloor(2, 1, 5);
        System.out.println("Апартаменты с 2 комнатами и этажом от 1 до 5: " + apartmentsByRoomsAndFloor);

        // Список квартир с площадью, превосходящей заданную
        List<Apartment> apartmentsByArea = system.getApartmentsByArea(80.0);
        System.out.println("Квартиры площадью более 80: " + apartmentsByArea);
    }
}