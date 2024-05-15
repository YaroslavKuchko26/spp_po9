package org.example.task03;

public class PhotoPrintResult extends PrintResult {
    protected String URI;

    public PhotoPrintResult(String URI) {
        this.URI = URI;
    }

    @Override
    public String toString() {
        return "PhotoPrintResult{" +
                "URI='" + URI + '\'' +
                '}';
    }
}
