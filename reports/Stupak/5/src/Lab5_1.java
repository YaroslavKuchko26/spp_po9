interface Ship {
    void Move();
}

// Абстрактный класс Военный Корабль, реализующий интерфейс Корабль
abstract class Battleship implements Ship {
    protected String Name;
    protected int Length;

    public Battleship(String Name, int Length) {
        this.Name = Name;
        this.Length = Length;
    }

    public abstract void fight();
}

// Класс Авианосец, наследующийся от Военного Корабля
class AircraftCarrier extends Battleship {
    private final int jetCount;

    public AircraftCarrier(String Name, int Length, int jetCount) {
        super(Name, Length);
        this.jetCount = jetCount;
    }

    @Override
    public void Move() {
        System.out.println("Авианосец " + Name + " плывет.");
    }

    @Override
    public void fight() {
        System.out.println("Авианосец " + Name + " ведет боевые действия с помощью " + jetCount + " самолетов.");
    }
}

// Пример использования классов
public class Lab5_1 {
    public static void main(String[] args) {
        AircraftCarrier airship = new AircraftCarrier("Адмирал Кузнецов", 1000, 50);
        airship.Move();
        airship.fight();
    }
}