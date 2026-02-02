import java.util.*;

// Replace part of employee names
public class EmployeeString23_ReplaceInNames {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Mr. Smith", 50000),
            new Employee(2, "Mr. Johnson", 60000),
            new Employee(3, "Ms. Williams", 55000)
        );
        
        System.out.println("Original names:");
        employees.forEach(emp -> System.out.println(emp.getName()));
        
        System.out.println("\nNames without title:");
        employees.stream()
                .map(emp -> emp.getName().replaceFirst("Mr\\.|Ms\\.", "").trim())
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
