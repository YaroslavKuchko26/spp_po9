package org.example.task2;

public class Student extends Pupil {

    public Student(String name, int age, String school) {
        super(name, age, school);
    }

    @Override
    public void goToSchool() {
        System.out.println("Student " + this.name + " went to " + this.school);
    }

    @Override
    public void doHomeWork() {
        System.out.println("Student " + this.name + " did homework.");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
