import java.util.*;
import java.util.stream.Collectors;

// Filter employees by name starting with letter
public class EmployeeString02_FilterByNameStartsWith {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 50000),
            new Employee(2, "Bob", 60000),
            new Employee(3, "Andrew", 55000),
            new Employee(4, "Amanda", 65000),
            new Employee(5, "Charlie", 70000)
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nEmployees whose name starts with 'A':");
        employees.stream()
                .filter(emp -> emp.getName().startsWith("A"))
                .forEach(System.out::println);
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
