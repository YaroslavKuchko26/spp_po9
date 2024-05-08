package org.example.task2;

public class Schoolkid extends Pupil {
    public Schoolkid(String name, int age, String school) {
        super(name, age, school);
    }

    @Override
    public void goToSchool() {
        System.out.println("Schoolkid " + this.name + " went to " + this.school);
    }

    @Override
    public void doHomeWork() {
        System.out.println("Schoolkid " + this.name + " did homework.");
    }

    @Override
    public String toString() {
        return "Schoolkid{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
