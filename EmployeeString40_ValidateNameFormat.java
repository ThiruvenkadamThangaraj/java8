import java.util.*;

// Validate Employee40 name format
public class EmployeeString40_ValidateNameFormat {
    public static void main(String[] args) {
        List<Employee40> employees = Arrays.asList(
            new Employee40(1, "Alice", 50000),
            new Employee40(2, "Bob123", 60000),
            new Employee40(3, "Charlie@", 55000),
            new Employee40(4, "David", 65000)
        );
        
        System.out.println("Valid Employee40 names (only letters):");
        employees.stream()
                .filter(emp -> emp.getName().matches("[a-zA-Z]+"))
                .forEach(System.out::println);
        
        System.out.println("\nInvalid Employee40 names:");
        employees.stream()
                .filter(emp -> !emp.getName().matches("[a-zA-Z]+"))
                .forEach(System.out::println);
    }
}

class Employee40 {
    private int id;
    private String name;
    private double salary;
    
    public Employee40(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee40{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
