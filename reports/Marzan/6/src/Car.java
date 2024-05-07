// Абстрактный класс, представляющий автомобиль
abstract class Car {
    protected String type;

    public String getType() {
        return type;
    }

    public abstract void manufacture();
}