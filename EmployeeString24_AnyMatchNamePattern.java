import java.util.*;

// Check if any Employee24 name matches pattern
public class EmployeeString24_AnyMatchNamePattern {
    public static void main(String[] args) {
        List<Employee24> employees = Arrays.asList(
            new Employee24(1, "Alice", "IT"),
            new Employee24(2, "Bob", "HR"),
            new Employee24(3, "Charlie", "Finance")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        boolean anyStartsWithA = employees.stream()
                .anyMatch(emp -> emp.getName().startsWith("A"));
        System.out.println("\nAny name starts with 'A'? " + anyStartsWithA);
        
        boolean allLongerThan2 = employees.stream()
                .allMatch(emp -> emp.getName().length() > 2);
        System.out.println("All names longer than 2 chars? " + allLongerThan2);
        
        boolean noneStartsWithZ = employees.stream()
                .noneMatch(emp -> emp.getName().startsWith("Z"));
        System.out.println("No name starts with 'Z'? " + noneStartsWithZ);
    }
}

class Employee24 {
    private int id;
    private String name;
    private String department;
    
    public Employee24(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee24{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
