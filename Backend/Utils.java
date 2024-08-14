import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Utils {
    public static void sortEmployeesByName(List<Employee> employees) {
        Collections.sort(employees, Comparator.comparing(Employee::getEname));
    }

    public static Employee searchEmployeeById(List<Employee> employees, int eid) {
        for (Employee employee : employees) {
            if (employee.getEid() == eid) {
                return employee;
            }
        }
        return null;
    }

    public static Employee searchEmployeeByEmail(List<Employee> employees, String email) {
        for (Employee employee : employees) {
            if (employee.getEmail().equalsIgnoreCase(email)) {
                return employee;
            }
        }
        return null;
    }
}