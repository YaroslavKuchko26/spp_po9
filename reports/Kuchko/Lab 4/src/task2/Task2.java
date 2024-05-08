package org.example.task2;

import java.time.LocalDate;

public class Task2 {
    public static void main(String[] args) {
        Planet planet = new Planet();

        planet.addContinent(new Continent("Евразия", 54.6));
        planet.addContinent(new Continent("Африка", 30.3));
        planet.addContinent(new Continent("Северная Америка", 24.4));
        planet.addContinent(new Continent("Южная Америка", 17.8));
        planet.addContinent(new Continent("Антарктида", 14.1));
        planet.addContinent(new Continent("Австралия", 7.7));

        System.out.println("Общая площадь: " + planet.getTotalSize());
        System.out.println("Континент по запросу 'евразия': " + planet.getContinentByName("евразия"));
    }
}