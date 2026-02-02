import java.util.*;

// Mask Employee44 names (show only first few characters)
public class EmployeeString44_MaskNames {
    public static void main(String[] args) {
        List<Employee44> employees = Arrays.asList(
            new Employee44(1, "Alice", 50000),
            new Employee44(2, "Bob", 60000),
            new Employee44(3, "Christopher", 55000)
        );
        
        System.out.println("Masked names (show first 3 chars):");
        employees.forEach(emp -> {
            String masked = emp.getName().length() > 3
                ? emp.getName().substring(0, 3) + "*".repeat(emp.getName().length() - 3)
                : emp.getName();
            System.out.println(emp.getName() + " -> " + masked);
        });
    }
}

class Employee44 {
    private int id;
    private String name;
    private double salary;
    
    public Employee44(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee44{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
