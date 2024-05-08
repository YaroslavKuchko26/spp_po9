package org.example.task1;

public abstract class Directory implements File {
    protected String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void open() {
        System.out.println("Directory " + path + " opened.");
    }

    @Override
    public void delete() {
        System.out.println("Directory " + path + " deleted.");
    }
}
