import java.util.*;

// Case-insensitive comparison of Employee15 names
public class EmployeeString15_CaseInsensitiveComparison {
    public static void main(String[] args) {
        List<Employee15> employees = Arrays.asList(
            new Employee15(1, "Alice", "IT"),
            new Employee15(2, "ALICE", "HR"),
            new Employee15(3, "alice", "Finance"),
            new Employee15(4, "Bob", "IT")
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

class Employee15 {
    private int id;
    private String name;
    private String department;
    
    public Employee15(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee15{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
