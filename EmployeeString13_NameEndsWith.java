import java.util.*;

// Filter employees by name ending with specific letter
public class EmployeeString13_NameEndsWith {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT"),
            new Employee(2, "Bob", "HR"),
            new Employee(3, "Charlie", "Finance"),
            new Employee(4, "Amanda", "IT"),
            new Employee(5, "David", "HR")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nEmployees whose name ends with 'e':");
        employees.stream()
                .filter(emp -> emp.getName().endsWith("e"))
                .forEach(System.out::println);
        
        System.out.println("\nEmployees whose name ends with 'a':");
        employees.stream()
                .filter(emp -> emp.getName().endsWith("a"))
                .forEach(System.out::println);
    }
}

class Employee {
    private int id;
    private String name;
    private String department;
    
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
