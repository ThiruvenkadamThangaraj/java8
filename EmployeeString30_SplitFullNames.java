import java.util.*;

// Split Employee30 full names into first and last
public class EmployeeString30_SplitFullNames {
    public static void main(String[] args) {
        List<Employee30> employees = Arrays.asList(
            new Employee30(1, "John Smith", 50000),
            new Employee30(2, "Alice Johnson", 60000),
            new Employee30(3, "Bob Williams", 55000)
        );
        
        System.out.println("Split names:");
        employees.forEach(emp -> {
            String[] parts = emp.getName().split(" ");
            String firstName = parts[0];
            String lastName = parts.length > 1 ? parts[1] : "";
            System.out.println("Full: " + emp.getName() + 
                             " -> First: " + firstName + 
                             ", Last: " + lastName);
        });
    }
}

class Employee30 {
    private int id;
    private String name;
    private double salary;
    
    public Employee30(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee30{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
