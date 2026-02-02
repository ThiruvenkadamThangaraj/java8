import java.util.*;

// Search employees by name pattern (regex)
public class EmployeeString19_RegexSearch {
    public static void main(String[] args) {
        List<Employee19> employees = Arrays.asList(
            new Employee19(1, "Alice123", "IT"),
            new Employee19(2, "Bob", "HR"),
            new Employee19(3, "Charlie456", "Finance"),
            new Employee19(4, "David", "IT")
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

class Employee19 {
    private int id;
    private String name;
    private String department;
    
    public Employee19(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee19{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
