import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    final static int DISK_SPACE = 1440;//Килобайт
    final static int NUMBER_OF_LOCATIONS = 12;//Количество участков
    final static int LOCATION_SIZE = DISK_SPACE / NUMBER_OF_LOCATIONS;//Размер участка
    static int lastDeletedFileInLocation = 0;//Изначально модифицированный участок - первый
    static int lastAddedFileInLocation = 0;//Изначально модифицированный участок - первый
    public static void deleteFile(ArrayList<ArrayList<File>> drive) {
        if(isDriveEmpty(drive)) {
            System.out.print("Drive is empty, delete drive instead (-. -)\n");
            return;
        }
        Scanner in = new Scanner(System.in);
        while(true) {
            printDrive(drive);
            System.out.print("Choose option:\n" +
                    "\t1. delete file\n" +
                    "\t... exit\n");
            int option = Integer.parseInt(in.next());
            switch (option) {
                case 1: {
                    System.out.print("Enter location number: ");
                    int location = Integer.parseInt(in.next()) - 1;
                    System.out.print("Enter file number: ");
                    int fileNumber = Integer.parseInt(in.next()) - 1;
                    File file = drive.get(location).remove(fileNumber);
                    if(file != null) {
                        System.out.print("File with path: " + file.getFilePath() + "\nWas deleted successfully\n");
                        lastDeletedFileInLocation = location;
                        return;
                    }
                    System.out.print("File wasn't deleted\n");
                }
                default: {
                    return;
                }
            }
        }
    }
    public static void addFile(ArrayList<ArrayList<File>> drive, File file) {
        double[] freeSpaceOfLocations = new double[drive.size()];
        double maxFreeSpaceOfLocation = -1;
        for(int i = 0; i < drive.size(); ++i) {
            double usedSpaceOfLocation = 0;
            for(int j = 0; j < drive.get(i).size(); ++j) {
                usedSpaceOfLocation += drive.get(i).get(j).getSize();
            }
            freeSpaceOfLocations[i] = LOCATION_SIZE - usedSpaceOfLocation;
            if(maxFreeSpaceOfLocation < freeSpaceOfLocations[i]) maxFreeSpaceOfLocation = freeSpaceOfLocations[i];
        }
        //Файл некуда добавить
        if(file.getSize() > maxFreeSpaceOfLocation) {
            System.out.print("File is too large for this drive. Clear the disk space\n");
            return;
        }
        //Добавление файла в свободный участок после последнего удалённого файла
        if(file.getSize() <= freeSpaceOfLocations[lastDeletedFileInLocation]) {
            System.out.print("Added via last deleted\n");
            drive.get(lastDeletedFileInLocation).add(file);
            lastAddedFileInLocation = lastDeletedFileInLocation;
            return;
        }
        //Добавление файла в свободный участок после последнего добавленного файла
        if(file.getSize() <= freeSpaceOfLocations[lastAddedFileInLocation]) {
            System.out.print("Added via last added\n");
            drive.get(lastAddedFileInLocation).add(file);
            return;
        }
        //Добавление в первый попавшийся свободный участок, если предыдущие не отработали
        for(int i = 0; i < freeSpaceOfLocations.length; ++i) {
            if(file.getSize() <= freeSpaceOfLocations[i]) {

                drive.get(i).add(file);
                lastAddedFileInLocation = i;
                //System.out.print("Added via via: " + lastAddedFileInLocation + "\n");
                return;
            }
        }
    }
    public static ArrayList<ArrayList<File>> createDrive() {
        ArrayList<ArrayList<File>> drive = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_LOCATIONS; ++i) {
            ArrayList<File> subDrive = new ArrayList<>();
            drive.add(subDrive);
        }
        return drive;
    }

    public static ArrayList<File> createFiles() {
        Scanner in = new Scanner(System.in);
        final String[] directoryNames = {"Проекты", "Финансы", "Маркетинг", "Кадры", "Архив"};
        final String[] fileNames = {"Лев", "Собака", "Кошка", "Зебра", "Пингвин"};
        final String[] fileExtensions = {"docx", "jpg", "mp3", "pdf", "txt"};
        System.out.print("Введите количество файлов, которые вы хотите добавить в файловую систему: ");
        int numberOfFiles = Integer.parseInt(in.next());
        ArrayList<File> files = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < numberOfFiles; ++i) {
            double size = random.nextInt(LOCATION_SIZE - 1) + 1;//1-119
            String fileExtension = fileExtensions[random.nextInt(fileExtensions.length)];
            String fileName = fileNames[random.nextInt(fileNames.length)];
            String directoryName = directoryNames[random.nextInt(directoryNames.length)];
            files.add(new File(size, fileExtension, fileName, directoryName));
        }
        for(int i = 0; i < files.size(); ++i) {
            System.out.print(files.get(i).getFilePath() + "\t" + files.get(i).getSize() + "\n");
        }
        return files;
    }

    public static void printDrive(ArrayList<ArrayList<File>> drive) {
        if(isDriveEmpty(drive)) {
            System.out.print("Drive is empty, check the FONT!\n");
            return;
        }
        for(int i = 0; i < drive.size(); ++i) {
            double freeSpaceOfLocations = LOCATION_SIZE;
            System.out.print("Location " + (i + 1) + ":");
            for(int j = 0; j < drive.get(i).size(); ++j) {
                if (j == 0) {
                    System.out.print("\n\tSize:\t\tPath to file:\n");
                }
                double size = drive.get(i).get(j).getSize();
                String filePath = drive.get(i).get(j).getFilePath();
                freeSpaceOfLocations -= size;
                System.out.print((j + 1) + ".\t" + size + "\t\t" + filePath + "\n");
            }
            System.out.print("Total size: " + freeSpaceOfLocations + "\n");
        }
    }

    public static void feelDrive(ArrayList<ArrayList<File>> drive, ArrayList<File> files) {
        for(int i = 0; i < files.size(); ++i) {
            addFile(drive, files.get(i));
        }
    }

    public static boolean isDriveEmpty(ArrayList<ArrayList<File>> drive) {
        for(int i = 0; i < drive.size(); ++i) {
            if(!drive.get(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void simulateFileSystem() {
        ArrayList<ArrayList<File>> drive = createDrive();
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Choose option: \n" +
                    "\t1. add files\n" +
                    "\t2. delete files\n" +
                    "\t3. print drive\n" +
                    "\t4. last modified location\n" +
                    "\t... exit\n");
            int option = Integer.parseInt(in.next());
            switch(option) {
                case 1: {
                    ArrayList<File> files = createFiles();
                    feelDrive(drive, files);
                    break;
                }
                case 2: {
                    deleteFile(drive);
                    break;
                }
                case 3: {
                    printDrive(drive);
                    break;
                }
                case 4: {
                    System.out.printf("Lastly added to location, number: " + (lastAddedFileInLocation + 1) +"\n" +
                            "Lastly deleted in location, number: " + (lastDeletedFileInLocation + 1) + "\n1");
                    break;
                }
                default: {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        simulateFileSystem();
    }
}