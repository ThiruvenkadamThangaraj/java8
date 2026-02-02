import java.util.*;

// Filter employees by name containing substring
public class EmployeeString09_NameContainsSubstring {
    public static void main(String[] args) {
        List<Employee09> employees = Arrays.asList(
            new Employee09(1, "Alexander", 50000),
            new Employee09(2, "Alexandra", 60000),
            new Employee09(3, "Bob", 55000),
            new Employee09(4, "Alex", 65000)
        );
        
        String searchTerm = "Alex";
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nEmployees with '" + searchTerm + "' in name:");
        employees.stream()
                .filter(emp -> emp.getName().contains(searchTerm))
                .forEach(System.out::println);
        
        System.out.println("\nCase-insensitive search for 'alex':");
        employees.stream()
                .filter(emp -> emp.getName().toLowerCase().contains("alex"))
                .forEach(System.out::println);
    }
}

class Employee09 {
    private int id;
    private String name;
    private double salary;
    
    public Employee09(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee09{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
