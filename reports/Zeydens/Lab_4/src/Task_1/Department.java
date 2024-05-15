import java.util.ArrayList;

public class Department {
    private ArrayList<String> departmentJobTypes;
    private ArrayList<employee> employees;
    private String departmentName;
    Department() {
        this.departmentJobTypes = new ArrayList<String>();
        this.employees = new ArrayList<employee>();
        this.departmentName = "";
    }
    Department(ArrayList<String> departmentJobTypes, ArrayList<employee> employees, String departmentName) {
        this.departmentJobTypes = departmentJobTypes;
        this.employees = employees;
        this.departmentName = departmentName;
    }
    public ArrayList<String> getDepartmentJobTypes() {
        return this.departmentJobTypes;
    }
    public ArrayList<employee> getEmployees() { return this.employees; }
    public String getDepartmentName() { return this.departmentName; }
    public void setDepartmentJobTypes(ArrayList<String> jobTypes) { this.departmentJobTypes = jobTypes; }
    public void setEmployees(ArrayList<employee> employees) {
        this.employees = employees;
    }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public void hireEmployee(String jobType, String lastName, String firstName, String middleName) {
        employees.add(new employee(jobType, lastName, firstName, middleName));
    }
    public employee fireEmployee(int i) { return employees.remove(i); }
    public void addJobType(String jobType) { this.departmentJobTypes.add(jobType); }
    public void removeJobType(String jobType) { this.departmentJobTypes.remove(jobType); }
    public void printJobTypes() {
        if(this.departmentJobTypes.isEmpty()) {
            System.out.print("Должности отсутствуют.\n");
            return;
        }
        System.out.print("Список должностей:\n");
        for(int i = 0; i < this.departmentJobTypes.size(); ++i) {
            System.out.print(this.departmentJobTypes.get(i) + ' ');
        }
        System.out.print("\n");
    }
    public void printEmployees() {
        if(this.employees.isEmpty()) {
            System.out.print("У отдела нет сотрудников.\n");
            return;
        }
        System.out.print("Список сотрудников: \n");
        for(int i = 0; i < this.employees.size(); ++i) {
            System.out.print((i + 1) + ". ");
            this.employees.get(i).print();
        }
    }
    public void printDepartmentName() {
        if(this.departmentName.isEmpty()) {
            System.out.print("У отдела нет названия.\n");
            return;
        }
        System.out.print("Название отдела: " + this.departmentName + '\n');
    }
    public void printDepartment() {
        printDepartmentName();
        printJobTypes();
        printEmployees();
    }
    public class employee {
        private String jobType;
        private String lastName;
        private String firstName;
        private String middleName;
        employee() {
            this.jobType = "";
            this.lastName = "";
            this.firstName = "";
            this.middleName = "";
        }
        employee(String jobType, String lastName, String firstName, String middleName) {
            this.jobType = jobType;
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
        }
        public String getJobType() {
            return this.jobType;
        }
        public String getLastName() {
            return this.lastName;
        }
        public String getFirstName() {
            return this.firstName;
        }
        public String getMiddleName() {
            return this.middleName;
        }
        public void setJobType(String jobType) {
            this.jobType = jobType;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }
        public void print() {
            System.out.print(this.lastName + ' ' + this.firstName + ' ' + this.middleName + " - " + this.jobType + '\n');
        }
    }
}
