import java.util.*;

// Split employee full names into first and last
public class EmployeeString30_SplitFullNames {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John Smith", 50000),
            new Employee(2, "Alice Johnson", 60000),
            new Employee(3, "Bob Williams", 55000)
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
