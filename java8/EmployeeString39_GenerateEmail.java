import java.util.*;

// Generate email from employee name
public class EmployeeString39_GenerateEmail {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John Smith", "IT"),
            new Employee(2, "Alice Johnson", "HR"),
            new Employee(3, "Bob", "Finance")
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
