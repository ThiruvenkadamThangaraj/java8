import java.util.*;
import java.util.stream.Collectors;

// Convert all Employee07 names to uppercase/lowercase
public class EmployeeString07_ChangeCaseNames {
    public static void main(String[] args) {
        List<Employee07> employees = Arrays.asList(
            new Employee07(1, "Alice", "IT"),
            new Employee07(2, "Bob", "HR"),
            new Employee07(3, "Charlie", "Finance")
        );
        
        System.out.println("Original:");
        employees.forEach(System.out::println);
        
        System.out.println("\nUppercase names:");
        List<String> upperNames = employees.stream()
                .map(emp -> emp.getName().toUpperCase())
                .collect(Collectors.toList());
        upperNames.forEach(System.out::println);
        
        System.out.println("\nLowercase names:");
        List<String> lowerNames = employees.stream()
                .map(emp -> emp.getName().toLowerCase())
                .collect(Collectors.toList());
        lowerNames.forEach(System.out::println);
    }
}

class Employee07 {
    private int id;
    private String name;
    private String department;
    
    public Employee07(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee07{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
