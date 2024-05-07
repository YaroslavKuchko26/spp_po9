import java.util.ArrayList;

public class IntegerSet {
    private ArrayList<Integer> elements;

    // Конструктор без параметров
    public IntegerSet() {
        this.elements = new ArrayList<>();
    }

    // Конструктор с начальной инициализацией
    public IntegerSet(ArrayList<Integer> elements) {
        this.elements = new ArrayList<>(elements);
    }

    // Метод для добавления элемента в множество
    public void add(int element) {
        if (!contains(element)) {
            elements.add(element);
        }
    }

    // Метод для удаления элемента из множества
    public void remove(int element) {
        elements.remove(Integer.valueOf(element));
    }

    // Метод для проверки, содержится ли элемент в множестве
    public boolean contains(int element) {
        return elements.contains(element);
    }

    // Метод для вычисления пересечения двух множеств
    public IntegerSet intersect(IntegerSet otherSet) {
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int element : elements) {
            if (otherSet.contains(element)) {
                intersection.add(element);
            }
        }
        return new IntegerSet(intersection);
    }

    // Переопределение метода equals для сравнения объектов IntegerSet
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        IntegerSet that = (IntegerSet) obj;
        return this.elements.equals(that.elements);
    }

    // Переопределение метода toString для вывода элементов множества
    @Override
    public String toString() {
        return "elements=" + elements;
    }
}

class Main {
    public static void main(String[] args) {
        // Примеры использования
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Вывод элементов множества
        System.out.println("Множество 1: " + set1);
        System.out.println("Множество 2: " + set2);

        // Пересечение двух множеств
        IntegerSet intersection = set1.intersect(set2);
        System.out.println("Пересечение множеств: " + intersection);

        // Проверка наличия элемента в множестве
        System.out.println("Множество 1 содержит элемент 2: " + set1.contains(2));

        // Проверка равенства множеств
        System.out.println("Множества 1 и 2 равны: " + set1.equals(set2));
    }
}
