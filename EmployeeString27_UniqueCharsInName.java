import java.util.*;

// Find employees with unique characters in name
public class EmployeeString27_UniqueCharsInName {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT"),
            new Employee(2, "Bob", "HR"),
            new Employee(3, "aabbcc", "Finance")
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
