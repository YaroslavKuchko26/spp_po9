package org.example.task2;

public abstract class Pupil {
    protected String name;
    protected int age;
    protected String school;

    public abstract void goToSchool();
    public abstract void doHomeWork();

    public Pupil(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }
}
