import java.util.*;

// Case-insensitive comparison of employee names
public class EmployeeString15_CaseInsensitiveComparison {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT"),
            new Employee(2, "ALICE", "HR"),
            new Employee(3, "alice", "Finance"),
            new Employee(4, "Bob", "IT")
        );
        
        String searchName = "alice";
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nCase-insensitive search for '" + searchName + "':");
        employees.stream()
                .filter(emp -> emp.getName().equalsIgnoreCase(searchName))
                .forEach(System.out::println);
        
        System.out.println("\nCase-insensitive sort:");
        employees.stream()
                .sorted(Comparator.comparing(
                    emp -> emp.getName().toLowerCase()))
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
