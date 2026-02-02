import java.util.*;

// Filter employees by multiple name criteria
public class EmployeeString18_MultipleNameCriteria {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 50000),
            new Employee(2, "Bob", 60000),
            new Employee(3, "Alexander", 55000),
            new Employee(4, "Amanda", 65000),
            new Employee(5, "Sam", 70000)
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nEmployees with name starting with 'A' and length > 5:");
        employees.stream()
                .filter(emp -> emp.getName().startsWith("A"))
                .filter(emp -> emp.getName().length() > 5)
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
