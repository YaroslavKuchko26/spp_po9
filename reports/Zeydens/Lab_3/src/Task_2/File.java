public class File {
    private final String diskName = "D:";
    private double size;
    private String extension;
    private String fileName;
    private String directoryName;
    private String directoryPath;
    private String filePath;
    File() {
        this.size = 0;
        this.extension = "";
        this.fileName = "";
        this.directoryName = "";
        this.directoryPath = "";
        this.filePath = "";
    }
    File(double size, String extension, String fileName, String directoryName) {
        this.size = size;
        this.extension = extension;
        this.fileName = fileName;
        this.directoryName = directoryName;
        this.directoryPath = diskName + "/" + directoryName;
        this.filePath = this.directoryPath + "/" + this.fileName + "." + this.extension;
    }
    public void setSize(double size) {this.size = size;}
    public void setExtension(String extension) {this.extension = extension;}
    public void setFileName(String fileName) {this.fileName = fileName;}
    public void setDirectoryName(String directoryName) {this.directoryName = directoryName;}
    public void setDirectoryPath(String directoryPath) {this.directoryPath = directoryPath;}
    public void setFilePath(String filePath) {this.filePath = filePath;}
    public String getDiskName() {return diskName;}
    public double getSize() {return size;}
    public String getExtension() {return extension;}
    public String getFileName() {return fileName;}
    public String getDirectoryName() {return directoryName;}
    public String getDirectoryPath() {return directoryPath;}
    public String getFilePath() {return filePath;}
}
