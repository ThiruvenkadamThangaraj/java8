import java.util.*;
import java.util.stream.Collectors;

// Find employees with duplicate names
public class EmployeeString14_DuplicateNames {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT"),
            new Employee(2, "Bob", "HR"),
            new Employee(3, "Alice", "Finance"),
            new Employee(4, "Charlie", "IT"),
            new Employee(5, "Bob", "Finance")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        Map<String, Long> nameCount = employees.stream()
                .collect(Collectors.groupingBy(
                    Employee::getName,
                    Collectors.counting()
                ));
        
        System.out.println("\nDuplicate names:");
        nameCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> 
                    System.out.println(entry.getKey() + " appears " + entry.getValue() + " times"));
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
