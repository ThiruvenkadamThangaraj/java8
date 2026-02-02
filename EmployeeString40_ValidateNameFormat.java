import java.util.*;

// Validate employee name format
public class EmployeeString40_ValidateNameFormat {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 50000),
            new Employee(2, "Bob123", 60000),
            new Employee(3, "Charlie@", 55000),
            new Employee(4, "David", 65000)
        );
        
        System.out.println("Valid employee names (only letters):");
        employees.stream()
                .filter(emp -> emp.getName().matches("[a-zA-Z]+"))
                .forEach(System.out::println);
        
        System.out.println("\nInvalid employee names:");
        employees.stream()
                .filter(emp -> !emp.getName().matches("[a-zA-Z]+"))
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
