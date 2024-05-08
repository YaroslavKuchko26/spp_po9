package org.example.task2;

import java.util.ArrayList;
import java.util.List;

public class Planet {

    private final List<Continent> continents = new ArrayList<>();

    public boolean addContinent(Continent continent) {
        return continents.add(continent);
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public double getTotalSize() {
        return continents.stream().mapToDouble(Continent::getSize).sum();
    }

    public Continent getContinentByName(String nameFilter) {
        return continents.stream().filter(cont -> cont.getName().equalsIgnoreCase(nameFilter))
                .findFirst().orElse(null);
    }
}
