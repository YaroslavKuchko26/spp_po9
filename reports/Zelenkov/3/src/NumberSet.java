import java.util.Arrays;

public class NumberSet {
    private double[] elements;
    private int capacity;
    private int factSize;

    public NumberSet(int capacity) {
        this.capacity = capacity;
        this.elements = new double[capacity];
        this.factSize = 0;
    }

    private int indexOf(double element) {
        for (int i = 0; i < factSize; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(double element) {
        return indexOf(element) != -1;
    }

    public void addElement(double element) {
        if(!contains(element)){
            if (factSize < capacity) {
                elements[factSize++] = element;
            }
            else {
                System.out.println("Множество полное, невозможно добавить новый элемент.");
            }
        }
    }

    public void removeElement(double element) {
        int index = indexOf(element);
        if (index != -1) {
            System.arraycopy(elements, index + 1, elements, index, factSize - index - 1);
            factSize--;
        } else {
            System.out.println("Элемент не найден в множестве.");
        }
    }

    public NumberSet union(NumberSet otherSet) {
        int newCapacity = this.capacity + otherSet.capacity;
        NumberSet newSet = new NumberSet(newCapacity);

        System.arraycopy(this.elements, 0, newSet.elements, 0, this.factSize);
        newSet.factSize = this.factSize;

        for (int i = 0; i < otherSet.factSize; i++) {
            if (!newSet.contains(otherSet.elements[i])) {
                newSet.addElement(otherSet.elements[i]);
            }
        }

        return newSet;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, factSize));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NumberSet that = (NumberSet) obj;
        return Arrays.equals(elements, that.elements);
    }
}
