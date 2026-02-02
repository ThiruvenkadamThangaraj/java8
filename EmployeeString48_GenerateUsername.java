import java.util.*;

// Create username from Employee48 name
public class EmployeeString48_GenerateUsername {
    public static void main(String[] args) {
        List<Employee48> employees = Arrays.asList(
            new Employee48(1, "John Smith", "IT"),
            new Employee48(2, "Alice Marie Johnson", "HR"),
            new Employee48(3, "Bob", "Finance")
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

class Employee48 {
    private int id;
    private String name;
    private String department;
    
    public Employee48(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee48{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
