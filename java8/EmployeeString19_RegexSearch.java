import java.util.*;

// Search employees by name pattern (regex)
public class EmployeeString19_RegexSearch {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice123", "IT"),
            new Employee(2, "Bob", "HR"),
            new Employee(3, "Charlie456", "Finance"),
            new Employee(4, "David", "IT")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nEmployees with numbers in name:");
        employees.stream()
                .filter(emp -> emp.getName().matches(".*\\d.*"))
                .forEach(System.out::println);
        
        System.out.println("\nEmployees with only alphabetic names:");
        employees.stream()
                .filter(emp -> emp.getName().matches("[a-zA-Z]+"))
                .forEach(System.out::println);
    }
}

class Employee {
    private int id;
    private String name;
    private String department;
    
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
