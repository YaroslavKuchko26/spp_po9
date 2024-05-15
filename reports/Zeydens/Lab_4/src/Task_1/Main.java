import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startSimulation();
    }
    public static void startSimulation() {
        Department myDepartment = new Department();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Choose option:\n" +
                    "\t1. Rename department\n" +
                    "\t2. Show department name\n" +
                    "\t3. Hire employee\n" +
                    "\t4. Fire employee\n" +
                    "\t5. Show employees in department\n" +
                    "\t6. Show job types\n" +
                    "\t7. Show department info\n" +
                    "\t... exit\n");
            int elem = Integer.parseInt(in.next());
            switch (elem) {
                case 1: {
                    System.out.print("Enter new department name: ");
                    String departmentName = in.next();
                    myDepartment.setDepartmentName(departmentName);
                    break;
                }
                case 2: {
                    myDepartment.printDepartmentName();
                    break;
                }
                case 3: {
                    System.out.print("Enter job type: ");
                    String jobType = in.next();
                    if(!myDepartment.getDepartmentJobTypes().contains(jobType)) {
                        myDepartment.addJobType(jobType);
                    }
                    System.out.print("Enter employee last name: ");
                    String lastName = in.next();
                    System.out.print("Enter employee first name: ");
                    String firstName = in.next();
                    System.out.print("Enter employee middle name: ");
                    String middleName = in.next();
                    myDepartment.hireEmployee(jobType, lastName, firstName, middleName);
                    break;
                }
                case 4: {
                    if (myDepartment.getEmployees().isEmpty()) {
                        System.out.print("There is nobody to fire!\n");
                        break;
                    }
                    myDepartment.printEmployees();
                    System.out.print("Choose employee number: ");
                    int employeeNumber;
                    while(true) {
                        employeeNumber = Integer.parseInt(in.next());
                        if (employeeNumber < 1 || employeeNumber > myDepartment.getEmployees().size()) {
                            System.out.print("Number doesn't exist, try again.\n");
                            continue;
                        }
                        break;
                    }
                    Department.employee firedEmployee = myDepartment.fireEmployee(employeeNumber - 1);
                    boolean jobTypeStillExists = false;
                    for(int i = 0; i < myDepartment.getEmployees().size(); ++i) {
                        if (myDepartment.getEmployees().get(i).getJobType().equals(firedEmployee.getJobType())) {
                            jobTypeStillExists = true;
                            break;
                        }
                    }
                    if (!jobTypeStillExists) { myDepartment.removeJobType(firedEmployee.getJobType()); }
                    break;
                }
                case 5: {
                    myDepartment.printEmployees();
                    break;
                }
                case 6: {
                    myDepartment.printJobTypes();
                    break;
                }
                case 7: {
                    myDepartment.printDepartment();
                    break;
                }
                default: {
                    return;
                }
            }
        }
    }
}