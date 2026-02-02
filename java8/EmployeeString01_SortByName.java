import java.util.*;

// Sort employees by name (String comparison)
public class EmployeeString01_SortByName {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Charlie", "IT"),
            new Employee(2, "Alice", "HR"),
            new Employee(3, "Bob", "Finance"),
            new Employee(4, "David", "IT")
        );
        
        System.out.println("Original employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nSorted by name (ascending):");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);
        
        System.out.println("\nSorted by name (descending):");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
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
