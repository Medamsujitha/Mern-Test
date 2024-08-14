import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {

    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            employees = FileHandler.loadEmployees();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employee records: " + e.getMessage());
        }

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Search Employee by Email");
            System.out.println("5. Sort Employees by Name");
            System.out.println("6. Delete Employee by ID");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (option) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    viewAllEmployees();
                    break;
                case 3:
                    searchEmployeeById(scanner);
                    break;
                case 4:
                    searchEmployeeByEmail(scanner);
                    break;
                case 5:
                    sortEmployeesByName();
                    break;
                case 6:
                    deleteEmployeeById(scanner);
                    break;
                case 7:
                    saveAndExit();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        int eid = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Employee Name: ");
        String ename = scanner.nextLine();
        System.out.print("Enter Employee DOB (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Employee Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Employee Mobile: ");
        String mobile = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Employee Department: ");
        String dept = scanner.nextLine();
        System.out.print("Enter Employee Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Employee Adhaar Card: ");
        String adhaarCard = scanner.nextLine();
        System.out.print("Enter Company Name: ");
        String companyName = scanner.nextLine();
        System.out.print("Enter Join Date (yyyy-mm-dd): ");
        String joinDate = scanner.nextLine();

        Employee employee = new Employee(eid, ename, java.sql.Date.valueOf(dob), email, mobile, salary, dept, address, adhaarCard, companyName, java.sql.Date.valueOf(joinDate));
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    private static void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static void searchEmployeeById(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        int eid = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Employee employee = Utils.searchEmployeeById(employees, eid);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void searchEmployeeByEmail(Scanner scanner) {
        System.out.print("Enter Employee Email: ");
        String email = scanner.nextLine();

        Employee employee = Utils.searchEmployeeByEmail(employees, email);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void sortEmployeesByName() {
        Utils.sortEmployeesByName(employees);
        System.out.println("Employees sorted by name.");
        viewAllEmployees();
    }

    private static void deleteEmployeeById(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        int eid = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Employee employee = Utils.searchEmployeeById(employees, eid);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void saveAndExit() {
        try {
            FileHandler.saveEmployee(employees);
            System.out.println("Employee records saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employee records: " + e.getMessage());
        }
        System.exit(0);
    }
}