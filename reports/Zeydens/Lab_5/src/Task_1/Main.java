// Интерфейс Здание
interface Building {
    void open();
    void close();
}
// Абстрактный класс Общественное Здание, реализующий интерфейс Здание
abstract class PublicBuilding implements Building {
    protected boolean opened;
    @Override
    public void open() {
        opened = true;
        System.out.println("Здание открыто");
    }
    @Override
    public void close() {
        opened = false;
        System.out.println("Здание закрыто");
    }
}

// Класс Театр, наследующийся от Общественного Здания
class Theatre extends PublicBuilding {
    private String name;
    public Theatre(String name) {
        this.name = name;
    }
    public void performance() {
        if (opened) {
            System.out.println("Идет представление в театре " + name);
        } else {
            System.out.println("Театр закрыт, представление не может быть показано");
        }
    }
}
// Пример использования
public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Большой");
        theatre.open();
        theatre.performance();
        theatre.close();
        theatre.performance();
    }
}