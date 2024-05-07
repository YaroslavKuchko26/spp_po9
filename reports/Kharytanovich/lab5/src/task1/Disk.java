package org.example.task1;

public class Disk extends Directory {

    @Override
    public void open() {
        System.out.println("Disk " + path + " opened.");
    }

    @Override
    public void delete() {
        return;
    }
}
