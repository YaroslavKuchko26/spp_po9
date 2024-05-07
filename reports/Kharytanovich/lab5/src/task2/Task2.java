package org.example.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        List<Pupil> pupils = new ArrayList<>();

        pupils.add(new Schoolkid("Denis", 15, "Gymnasium #2"));
        pupils.add(new Student("Zakhar", 19, "BrSTU"));
        pupils.add(new Schoolkid("Kirill", 16, "Gymnasium #2"));
        pupils.add(new Student("Dasha", 20, "BrSTU"));
        pupils.add(new Schoolkid("Andrey", 13, "Gymnasium #2"));

        pupils.stream().filter(obj -> obj instanceof Student).forEach(System.out::println);
        pupils.stream().filter(obj -> obj instanceof Schoolkid).forEach(System.out::println);
    }
}
