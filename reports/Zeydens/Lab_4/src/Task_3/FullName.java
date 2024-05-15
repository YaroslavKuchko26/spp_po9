import java.util.ArrayList;
import java.util.Arrays;
public class FullName {
    private String lastName;
    private String firstName;
    private String middleName;
    FullName() {
        this.lastName = "";
        this.firstName = "";
        this.middleName = "";
    }
    FullName(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
    public String getLastName() { return this.lastName; }
    public String getFirstName() { return this.firstName; }
    public String getMiddleName() { return this.middleName; }
    public ArrayList<String> getFullName() {
        return new ArrayList<>(Arrays.asList(this.lastName, this.firstName, this.middleName));
    }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public boolean equals(FullName fullName) {
        boolean lastName = this.lastName.equals(fullName.lastName);
        boolean firstName = this.firstName.equals(fullName.firstName);
        boolean middleName = this.middleName.equals(fullName.middleName);
        return lastName && firstName && middleName;
    }
    public void print() {
        System.out.print(this.lastName + ' ' + this.firstName + ' ' + this.middleName + '\n');
    }
}
