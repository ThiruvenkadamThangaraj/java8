import java.util.*;
import java.util.stream.Collectors;

// Join employee names with delimiter
public class EmployeeString12_JoinNames {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 50000),
            new Employee(2, "Bob", 60000),
            new Employee(3, "Charlie", 55000),
            new Employee(4, "David", 65000)
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        String namesComma = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println("\nNames with comma: " + namesComma);
        
        String namesWithPrefix = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "Employees: [", "]"));
        System.out.println("Names with prefix/suffix: " + namesWithPrefix);
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;
    
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
