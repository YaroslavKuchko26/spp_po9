import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// Общий интерфейс компонента (каталога или файла)
interface FileSystemComponent {
    void showDetails(int depth);
}
// Класс, представляющий файл
class File implements FileSystemComponent {
    private String name;
    private int size;
    private Date createdDate;
    private boolean canRead;
    private boolean canWrite;
    private boolean canExecute;

    public File(String name, int size, Date createdDate, boolean canRead, boolean canWrite, boolean canExecute) {
        this.name = name;
        this.size = size;
        this.createdDate = createdDate;
        this.canRead = canRead;
        this.canWrite = canWrite;
        this.canExecute = canExecute;
    }

    @Override
    public void showDetails(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("\t");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String formattedDate = dateFormat.format(createdDate);

        System.out.print(indent + " " + name);
        System.out.print(" " + formattedDate);
        System.out.print(" " + size + " b ");
        if(this.canRead) { System.out.print("r"); }
        else { System.out.print("-"); }
        if(this.canWrite) { System.out.print("w"); }
        else { System.out.print("-"); }
        if(this.canExecute) { System.out.print("x\n"); }
        else { System.out.print("-\n"); }
    }
}

// Класс, представляющий директорию
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;
    public Directory(String name) {
        this.name = name;
        components = new ArrayList<>();
    }
    public void addComponent(FileSystemComponent component) { components.add(component); }
    public void removeComponent(FileSystemComponent component) { components.remove(component); }
    @Override
    public void showDetails(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) { indent.append("\t"); }
        System.out.println(indent + " " + name);
        for (FileSystemComponent component : components) { component.showDetails(depth + 1); }
    }
}
// Пример использования
public class Main {
    public static void main(String[] args) {
        File file1 = new File("file1.txt", 100, new Date(), true, true, false);
        File file2 = new File("file2.txt", 50, new Date(), true, false, false);
        File file3 = new File("file3.txt", 75, new Date(), true, true, true);
        File file4 = new File("file4.txt", 120, new Date(), false, false, false);

        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");
        Directory dir3 = new Directory("dir3");
        Directory dir4 = new Directory("dir4");

        dir1.addComponent(file1);
        dir1.addComponent(file2);

        dir2.addComponent(dir1);
        dir2.addComponent(file3);

        dir3.addComponent(file4);

        dir4.addComponent(dir2);
        dir4.addComponent(dir3);

        dir4.showDetails(0);
    }
}