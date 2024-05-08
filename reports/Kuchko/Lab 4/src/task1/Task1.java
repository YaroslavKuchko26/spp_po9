package org.example.task1;

import java.time.LocalDate;

public class Task1 {
    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        notepad.add(LocalDate.now(), "Запись в записной книжке номер 1");
        notepad.add(LocalDate.now(), "Запись в записной книжке номер 2");
        notepad.add(LocalDate.now(), "Запись в записной книжке номер 3");
        notepad.add(LocalDate.of(2024, 4, 8), "Запись в записной книжке номер 1");
        notepad.add(LocalDate.of(2024, 4, 8), "Запись в записной книжке номер 2");

        System.out.println(notepad.getValuesByDate(LocalDate.now()));
        System.out.println();
        System.out.println(notepad.getValuesByDate(LocalDate.of(2024, 4, 8)));
    }
}