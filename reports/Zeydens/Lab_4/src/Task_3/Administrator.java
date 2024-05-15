import java.util.ArrayList;

public class Administrator {
    private FullName fullName;
    private ArrayList<FullName> blackList;
    Administrator() {
        this.fullName = new FullName();
        this.blackList = new ArrayList<>();
    }
    Administrator(FullName fullName, ArrayList<FullName> blackList) {
        this.fullName = fullName;
        this.blackList = blackList;
    }
    public FullName getFullName() { return this.fullName; }
    public ArrayList<FullName> getBlackList() { return this.blackList; }
    public void setFullName(FullName fullName) { this.fullName = fullName; }
    public void setBlackList(ArrayList<FullName> blackList) { this.blackList = blackList; }
    public void addToBlackList(FullName fullName) { this.blackList.add(fullName); }
    public void deleteFromBlackList(FullName fullName) { this.blackList.remove(fullName); }
    public void print() {
        this.fullName.print();
        if(this.blackList.isEmpty()) { return; }
        System.out.print("Читатели в чёрном списке: ");
        for(int i = 0; i < this.blackList.size(); ++i) {
            System.out.print(i + 1 + ". ");
            this.blackList.get(i).print();
        }
    }
}
