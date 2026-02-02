import java.util.*;

// Create username from employee name
public class EmployeeString48_GenerateUsername {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John Smith", "IT"),
            new Employee(2, "Alice Marie Johnson", "HR"),
            new Employee(3, "Bob", "Finance")
        );
        
        System.out.println("Generated usernames:");
        employees.forEach(emp -> {
            String username = generateUsername(emp.getName(), emp.getId());
            System.out.println(emp.getName() + " -> " + username);
        });
    }
    
    static String generateUsername(String fullName, int id) {
        String[] parts = fullName.split(" ");
        StringBuilder username = new StringBuilder();
        
        if (parts.length > 1) {
            username.append(parts[0].toLowerCase().charAt(0));
            username.append(parts[parts.length - 1].toLowerCase());
        } else {
            username.append(parts[0].toLowerCase());
        }
        
        username.append(id);
        return username.toString();
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
