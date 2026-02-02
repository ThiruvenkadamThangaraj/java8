import java.util.*;

// Find employees with shortest name
public class EmployeeString21_ShortestName {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Christopher", 50000),
            new Employee(2, "Bo", 60000),
            new Employee(3, "Sam", 55000),
            new Employee(4, "Alexandria", 65000)
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        int minLength = employees.stream()
                .mapToInt(emp -> emp.getName().length())
                .min()
                .orElse(0);
        
        System.out.println("\nEmployees with shortest name (length " + minLength + "):");
        employees.stream()
                .filter(emp -> emp.getName().length() == minLength)
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
