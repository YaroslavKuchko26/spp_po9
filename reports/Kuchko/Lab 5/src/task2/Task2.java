package org.example.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        List<Pupil> pupils = new ArrayList<>();

        pupils.add(new Schoolkid("Mark", 15, "Velikorita School")); 
        pupils.add(new Student("Yaroslav", 19, "BrSTU")); 
        pupils.add(new Schoolkid("Dima", 16, "Gymnasium #1")); 
        pupils.add(new Student("Dasha", 20, "BrSTU")); 
        pupils.add(new Student("Kostya", 21, "BrSTU"));

        pupils.stream().filter(obj -> obj instanceof Student).forEach(System.out::println);
        pupils.stream().filter(obj -> obj instanceof Schoolkid).forEach(System.out::println);
    }
}
