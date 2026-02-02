import java.util.*;

// Trim whitespace from Employee29 names
public class EmployeeString29_TrimNames {
    public static void main(String[] args) {
        List<Employee29> employees = Arrays.asList(
            new Employee29(1, "  Alice  ", 50000),
            new Employee29(2, " Bob ", 60000),
            new Employee29(3, "Charlie", 55000)
        );
        
        System.out.println("Original names (with quotes to show spaces):");
        employees.forEach(emp -> 
            System.out.println("'" + emp.getName() + "'"));
        
        System.out.println("\nTrimmed names:");
        employees.stream()
                .map(emp -> emp.getName().trim())
                .forEach(name -> System.out.println("'" + name + "'"));
    }
}

class Employee29 {
    private int id;
    private String name;
    private double salary;
    
    public Employee29(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee29{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
