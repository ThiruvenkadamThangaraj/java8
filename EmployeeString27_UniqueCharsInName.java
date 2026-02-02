import java.util.*;

// Find employees with unique characters in name
public class EmployeeString27_UniqueCharsInName {
    public static void main(String[] args) {
        List<Employee27> employees = Arrays.asList(
            new Employee27(1, "Alice", "IT"),
            new Employee27(2, "Bob", "HR"),
            new Employee27(3, "aabbcc", "Finance")
        );
        
        System.out.println("Unique character count in names:");
        employees.forEach(emp -> {
            long uniqueChars = emp.getName().toLowerCase().chars()
                    .distinct()
                    .count();
            System.out.println(emp.getName() + ": " + uniqueChars + " unique characters");
        });
    }
}

class Employee27 {
    private int id;
    private String name;
    private String department;
    
    public Employee27(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee27{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
