package org.example.task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Notepad {
    private static final String VALUES_DELIMITER = "\n-------------------\n";

    private final List<Note> notes = new ArrayList<>();

    public boolean add(LocalDate date, String value) {
        return notes.add(new Note(date, value));
    }
    public String getValuesByDate(LocalDate dateFilter) {
        return "Записи на " + dateFilter + "\n" + notes.stream().filter(obj -> obj.getDate().equals(dateFilter)).map(Note::getValue).collect(Collectors.joining(VALUES_DELIMITER)) + "\n" + dateFilter;
    }

    private class Note {
        private LocalDate date;
        private String value;

        public Note(LocalDate date, String value) {
            this.date = date;
            this.value = value;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
