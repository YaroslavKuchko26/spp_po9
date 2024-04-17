package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CustomCharArray {

    private final ArrayList<Character> values;

    public CustomCharArray() {
        values = new ArrayList<>();
    }

    public CustomCharArray(Collection<Character> values) {
        this.values = new ArrayList<>(values);
    }

    public ArrayList<Character> getValues() {
        return values;
    }

    public boolean add(Character character) {
        return !values.contains(character) && values.add(character);
    }

    public boolean remove(Character character) {
        return values.remove(character);
    }

    public boolean contains(Character character) {
        return values.contains(character);
    }

    public CustomCharArray intersection(CustomCharArray obj) {
        List<Character> valClone = new ArrayList<>(values);
        List<Character> objClone = new ArrayList<>(obj.getValues());

        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < valClone.size(); i++) {
            Character val = valClone.get(i);
            if (objClone.contains(val)) {
                result.add(val);
                if (valClone.remove(val)) {
                    i--;
                }
                objClone.remove(val);
            }
        }

        return new CustomCharArray(result);
    }

    @Override
    public String toString() {
        return "CustomCharArray{" +
                "values=" + values +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomCharArray that = (CustomCharArray) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
