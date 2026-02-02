import java.util.*;

// Generate email from Employee39 name
public class EmployeeString39_GenerateEmail {
    public static void main(String[] args) {
        List<Employee39> employees = Arrays.asList(
            new Employee39(1, "John Smith", "IT"),
            new Employee39(2, "Alice Johnson", "HR"),
            new Employee39(3, "Bob", "Finance")
        );
        
        System.out.println("Generated emails:");
        employees.forEach(emp -> {
            String email = emp.getName().toLowerCase()
                    .replaceAll(" ", ".")
                    + "@company.com";
            System.out.println(emp.getName() + " -> " + email);
        });
    }
}

class Employee39 {
    private int id;
    private String name;
    private String department;
    
    public Employee39(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee39{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
